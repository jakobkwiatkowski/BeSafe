package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrNosBezApteczki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_nos_bez_apteczki)

        val dalej = findViewById<Button>(R.id.Dalej2)
        val wrocA8 = findViewById<ImageView>(R.id.wrocA8)
        val domowaA8 = findViewById<ImageView>(R.id.domowaA8)

        dalej.setOnClickListener {
            val intent = Intent(this, KrNos2::class.java)
            startActivity(intent)
        }

        wrocA8.setOnClickListener {
            val intent = Intent(this, KrZNosa::class.java)
            startActivity(intent)
        }

        domowaA8.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

    }
}