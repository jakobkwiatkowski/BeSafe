package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrNosBezApteczki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_nos_bez_apteczki)

        val dalej = findViewById<Button>(R.id.Dalej2)

        dalej.setOnClickListener {
            val intent = Intent(this, KrNos2::class.java)
            startActivity(intent)
        }

    }
}