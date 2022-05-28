package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrNieZNosa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_nie_znosa)

        val jestapteczka = findViewById<Button>(R.id.buttonczyjesttak3)
        val niemaapteczki = findViewById<Button>(R.id.buttonczyjestnie3)

        jestapteczka.setOnClickListener {
            val intent = Intent(this, KrApteczka::class.java)
            startActivity(intent)
        }

        niemaapteczki.setOnClickListener {
            val intent = Intent(this, KrBezApteczki::class.java)
            startActivity(intent)
        }
    }
}