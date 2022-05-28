package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrBezpiecznie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_bezpiecznie)

        val krznosa = findViewById<Button>(R.id.buttonczyjesttak2)
        val krnieznosa = findViewById<Button>(R.id.buttonczyjestnie2)

        krznosa.setOnClickListener {
            val intent = Intent(this, KrZNosa::class.java)
            startActivity(intent)
        }

        krnieznosa.setOnClickListener {
            val intent = Intent(this, KrNieZNosa::class.java)
            startActivity(intent)
        }

    }
}