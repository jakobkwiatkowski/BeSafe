package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrApteczka : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_apteczka)

        val dalej = findViewById<Button>(R.id.dalej2)

        dalej.setOnClickListener {
            val intent = Intent(this, KrApteczka2::class.java)
            startActivity(intent)
        }
    }
}