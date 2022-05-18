package com.example.besafe

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*


class LogowanieActivity : AppCompatActivity() {

    val databaseReference: DatabaseReference = FirebaseDatabase.getInstance()
        .getReferenceFromUrl("https://besafe-ecb67-default-rtdb.europe-west1.firebasedatabase.app/")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logowanie)

        val emailInput = findViewById<EditText>(R.id.PhoneNumberLoginInput)
        val passwordInput = findViewById<EditText>(R.id.PasswordLoginInput)
        val loginButton = findViewById<Button>(R.id.LoginButton)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
        }

        textDisappear(emailInput)
        textDisappear(passwordInput)
    }


    fun logowanie() {

        val phoneInput = findViewById<EditText>(R.id.PhoneNumberLoginInput)
        val phonetxt = phoneInput.text.toString().trim()

        var login: HashMap<*, *>
        var potwierdzenie: Boolean
        databaseReference.child("users").get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
            login = it.value as HashMap<*, *>

//            for ((key, value) in login) {
//                println("$key = $value")
//            }

            potwierdzenie = login.containsKey(phonetxt)
            if (potwierdzenie) {
                databaseReference.child("users").child(phonetxt)
                    .child("phone number").get()
            }
        }
    }


    private fun textDisappear(napis:EditText){
        napis.setOnClickListener {
            napis.text.clear()
        }
    }
}