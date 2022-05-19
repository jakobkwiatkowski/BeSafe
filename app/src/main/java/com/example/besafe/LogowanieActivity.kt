package com.example.besafe

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
                            Toast.makeText(baseContext,"Witaj ${snapshot.child("name").value.toString()}",Toast.LENGTH_SHORT).show()
                            phoneInput.text.clear()
                            passwordInput.text.clear()
                        } else {
                            Toast.makeText(baseContext,"Nie udało się zalogować",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

        }
    }
}