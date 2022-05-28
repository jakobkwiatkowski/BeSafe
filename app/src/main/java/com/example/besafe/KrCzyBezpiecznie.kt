package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrCzyBezpiecznie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_czy_bezpiecznie)

        val czyjesttak = findViewById<Button>(R.id.buttonczyjesttak)
        val czyjestnie = findViewById<Button>(R.id.buttonczyjestnie)

        czyjesttak.setOnClickListener {
            val intent = Intent(this, KrBezpiecznie::class.java)
            startActivity(intent)
        }

        czyjestnie.setOnClickListener {
            val intent = Intent(this, KrNiebezpiecznie::class.java)
            startActivity(intent)
        }
    }
}