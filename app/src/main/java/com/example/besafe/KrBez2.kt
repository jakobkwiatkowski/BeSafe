package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrBez2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_bez2)

        val dalej = findViewById<Button>(R.id.dalej6)

        dalej.setOnClickListener {
            val intent = Intent(this, KrApteczka3::class.java)
            startActivity(intent)
        }
    }
}