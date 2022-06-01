package com.example.besafe

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import at.favre.lib.crypto.bcrypt.BCrypt
import com.google.firebase.database.*

class RejestracjaActivity : AppCompatActivity() {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance()
        .getReferenceFromUrl("https://besafe-ecb67-default-rtdb.europe-west1.firebasedatabase.app/")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rejestracja)

        val registerButton = findViewById<Button>(R.id.RegisterButton)
        registerButton.setOnClickListener {
            register()
        }
    }

    fun register() {

        val phoneInput = findViewById<EditText>(R.id.PhoneInput)
        val passwordInput = findViewById<EditText>(R.id.PasswordInput)
        val nameInput = findViewById<EditText>(R.id.NameInput)
        val surnameInput = findViewById<EditText>(R.id.SurnameInput)
        val codeInput = findViewById<EditText>(R.id.CodeInput)

        val nametxt = nameInput.text.toString().trim()
        val surnametxt = surnameInput.text.toString().trim()
        val phonetxt = phoneInput.text.toString().trim()
        val passwordtxt = passwordInput.text.toString().trim()
        val codetxt = codeInput.text.toString().trim()

        databaseReference.child("users").child(phonetxt).get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")

            when {

                (nametxt.isEmpty() || surnametxt.isEmpty() || phonetxt.isEmpty() || passwordtxt.isEmpty() || codetxt.isEmpty()) -> {
                    Toast.makeText(this, "Proszę wypełnić wszystkie pola", Toast.LENGTH_SHORT)
                        .show()
                }

                (passwordtxt.length < 6) -> {
                    Toast.makeText(
                        this,
                        "Hasło powinno zawierać przynajmniej sześć znaków",
                        Toast.LENGTH_SHORT
                    ).show()
                    passwordInput.text.clear()
                }

                (!phonetxt.replace("\\s".toRegex(), "").isDigitsOnly()) -> {
                    Toast.makeText(
                        this,
                        "Numer telefonu powinien składać się wyłącznie z cyfr",
                        Toast.LENGTH_SHORT
                    ).show()
                    phoneInput.text.clear()
                }

                (it.value?.equals(null) == false) -> {
                    Toast.makeText(
                        this,
                        "Numer telefonu występuje w bazie",
                        Toast.LENGTH_SHORT
                    ).show()
                    phoneInput.text.clear()
                }

                else -> {

                    // Hashowanie
                    val passHash = BCrypt.withDefaults().hashToString(12, passwordtxt.toCharArray())

                    var klucze: HashMap<*, *>
                    var potwierdzenie: Boolean
                    databaseReference.child("ActivationKeys").get().addOnSuccessListener {
                        Log.i("firebase", "Got value ${it.value}")
                        klucze = it.value as HashMap<*, *>
                        potwierdzenie = klucze.containsKey(codetxt)
                        if (potwierdzenie) {
                            Toast.makeText(
                                this,
                                "Poprawny indywidualny kod weryfikacyjny",
                                Toast.LENGTH_SHORT
                            ).show()

                            databaseReference.child("users").child(phonetxt)
                                .child("verification code")
                                .setValue(codetxt)
                            databaseReference.child("users").child(phonetxt).child("name")
                                .setValue(nametxt)
                            databaseReference.child("users").child(phonetxt).child("surname")
                                .setValue(surnametxt)
                            databaseReference.child("users").child(phonetxt).child("phone number")
                                .setValue(phonetxt)
                            // Hashowanie
                            databaseReference.child("users").child(phonetxt).child("password")
                                .setValue(passHash)
                            // Usunięcie wprowadzonego klucza weryfikacyjnego spośród dostępnych
                            databaseReference.child("ActivationKeys").child(codetxt).removeValue()

                            Toast.makeText(
                                this,
                                "Rejestracja przebiegła pomyślnie",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            finish()
                        } else {
                            Toast.makeText(
                                this,
                                "Kod weryfikacyjny nie występuje w bazie - pozyskaj nowy",
                                Toast.LENGTH_SHORT
                            ).show()
                            codeInput.text.clear()
                        }
                    }.addOnFailureListener {
                        Log.e("firebase", "Error getting data", it)
                    }

                }
            }
        }.addOnFailureListener {
            Log.e("firebase", "Error getting data", it)
        }
    }
}