package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrZNosa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_znosa)

        val jestaptecza = findViewById<Button>(R.id.buttonczyjesttak4)
        val niemaapteczki = findViewById<Button>(R.id.buttonczyjestnie4)

        jestaptecza.setOnClickListener {
            val intent = Intent(this, KrNosApteczka::class.java)
            startActivity(intent)
        }

        niemaapteczki.setOnClickListener {
            val intent = Intent(this, KrNosBezApteczki::class.java)
            startActivity(intent)
        }
    }
}