package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrBez2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_bez2)

        val dalej = findViewById<Button>(R.id.dalej6)
        val wrocA14 = findViewById<ImageView>(R.id.wrocA14)
        val domowaA14 = findViewById<ImageView>(R.id.domowaA14)

        dalej.setOnClickListener {
            val intent = Intent(this, KrBezApteczki3::class.java)
            startActivity(intent)
        }

        wrocA14.setOnClickListener {
            val intent = Intent(this, KrBezApteczki::class.java)
            startActivity(intent)
        }

        domowaA14.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

    }
}