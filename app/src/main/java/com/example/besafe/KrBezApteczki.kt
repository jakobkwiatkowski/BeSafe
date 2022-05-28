package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrBezApteczki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_bez_apteczki)

        val dalej = findViewById<Button>(R.id.dalej5)

        dalej.setOnClickListener {
            val intent = Intent(this, KrBez2::class.java)
            startActivity(intent)
        }
    }
}