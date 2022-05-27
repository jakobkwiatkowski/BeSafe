package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class StartActivity : AppCompatActivity() {

    private var wyjdz: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        wyjdz = findViewById(R.id.wyjdzButton)

        wyjdz?.setOnClickListener {

            finish()

            Toast.makeText(
                this,
                "Zaloguj się ponownie",
                Toast.LENGTH_SHORT
            )
                .show()

            val intent = Intent(this, LogowanieActivity::class.java)
            startActivity(intent)
        }

    }
}