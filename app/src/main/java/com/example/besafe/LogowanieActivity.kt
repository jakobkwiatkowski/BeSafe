package com.example.besafe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import at.favre.lib.crypto.bcrypt.BCrypt
import com.google.firebase.database.*


class LogowanieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logowanie)

        val phoneInput = findViewById<EditText>(R.id.PhoneNumberLoginInput)
        val passwordInput = findViewById<EditText>(R.id.PasswordLoginInput)
        val loginButton = findViewById<Button>(R.id.LoginButton)

        loginButton.setOnClickListener {
            val phone = phoneInput.text.toString()
            val password = passwordInput.text.toString()

            when {

                (phone.isEmpty() || password.isEmpty()) -> {
                    Toast.makeText(this, "Proszę wypełnić wszystkie pola", Toast.LENGTH_SHORT)
                        .show()
                }

                (password.length < 6) -> {
                    Toast.makeText(
                        this,
                        "Hasło zawiera przynajmniej sześć znaków",
                        Toast.LENGTH_SHORT
                    ).show()
                    passwordInput.text.clear()
                }

                (!phone.replace("\\s".toRegex(), "").isDigitsOnly()) -> {
                    Toast.makeText(
                        this,
                        "Numer telefonu składa się wyłącznie z cyfr",
                        Toast.LENGTH_SHORT
                    ).show()
                    phoneInput.text.clear()
                }

                else -> {

                    val databaseReference: DatabaseReference = FirebaseDatabase.getInstance()
                        .getReferenceFromUrl("https://besafe-ecb67-default-rtdb.europe-west1.firebasedatabase.app/users/$phone")

                    databaseReference.addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }

                        override fun onDataChange(snapshot: DataSnapshot) {
                            if (snapshot.exists()) {
                                val hash = snapshot.child("password").value.toString()
                                val result = BCrypt.verifyer().verify(password.toCharArray(), hash)
                                if (result.verified) {
                                    Toast.makeText(
                                        baseContext,
                                        "Witaj, ${snapshot.child("name").value.toString()} !",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    phoneInput.text.clear()
                                    passwordInput.text.clear()
                                    goStart()
                                } else {
                                    Toast.makeText(
                                        baseContext,
                                        "Nie udało się zalogować - nieprawidłowe hasło",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                    baseContext,
                                    "Nie udało się zalogować - nieprawidłowy numer telefonu",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    })

                }
            }
        }
    }

    private fun goStart() {
        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
    }
}