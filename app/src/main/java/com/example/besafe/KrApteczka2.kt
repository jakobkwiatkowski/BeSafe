package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrApteczka2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_apteczka2)

        val dalej = findViewById<Button>(R.id.dalej4)
        val wrocA11 = findViewById<ImageView>(R.id.wrocA11)
        val domowaA11 = findViewById<ImageView>(R.id.domowaA11)

        dalej.setOnClickListener {
            val intent = Intent(this, KrApteczka3::class.java)
            startActivity(intent)
        }

        wrocA11.setOnClickListener {
            val intent = Intent(this, KrApteczka::class.java)
            startActivity(intent)
        }

        domowaA11.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

    }
}