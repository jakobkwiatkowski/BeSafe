package com.example.besafe

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import java.util.*
import kotlin.collections.HashMap

class RejestracjaActivity : AppCompatActivity() {

    val databaseReference: DatabaseReference = FirebaseDatabase.getInstance()
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


        val nametxt = nameInput.getText().toString().trim()
        val surnametxt = surnameInput.getText().toString().trim()
        val phonetxt = phoneInput.getText().toString().trim()
        val passwordtxt = passwordInput.getText().toString().trim()
        val codetxt = codeInput.getText().toString().trim()


        if (nametxt.isEmpty() || surnametxt.isEmpty() || phonetxt.isEmpty() || passwordtxt.isEmpty() || codetxt.isEmpty()) {
            Toast.makeText(this, "Proszę wypełnić wszystkie pola", Toast.LENGTH_SHORT).show()
        } else {
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
                    val newID = UUID.randomUUID().toString()
                    databaseReference.child("users").child(phonetxt).child("verification code")
                        .setValue(codetxt)
                    databaseReference.child("users").child(phonetxt).child("name").setValue(nametxt)
                    databaseReference.child("users").child(phonetxt).child("surname").setValue(surnametxt)
                    databaseReference.child("users").child(phonetxt).child("phone number")
                        .setValue(phonetxt)
                    databaseReference.child("users").child(phonetxt).child("password").setValue(passwordtxt)

                    Toast.makeText(this, "Rejestracja przebiegła pomyślnie", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Kod weryfikacyjny nie występuje w bazie - uzyskaj nowy",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }

        }
    }

}