package com.example.besafe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LogowanieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logowanie)

        val emailInput = findViewById<EditText>(R.id.EmailLoginInput)
        val passwordInput = findViewById<EditText>(R.id.PasswordLoginInput)
        val loginButton = findViewById<Button>(R.id.LoginButton)

        loginButton.setOnClickListener {
            val email = emailInput.getText().toString()
            val password = passwordInput.getText().toString()
        }

    }
}