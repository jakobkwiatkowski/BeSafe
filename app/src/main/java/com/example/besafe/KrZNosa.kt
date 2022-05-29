package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrZNosa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_znosa)

        val jestaptecza = findViewById<Button>(R.id.buttonczyjesttak4)
        val niemaapteczki = findViewById<Button>(R.id.buttonczyjestnie4)
        val wrocA4 = findViewById<ImageView>(R.id.wrocA4)
        val domowaA4 = findViewById<ImageView>(R.id.domowaA4)

        jestaptecza.setOnClickListener {
            val intent = Intent(this, KrNosApteczka::class.java)
            startActivity(intent)
        }

        niemaapteczki.setOnClickListener {
            val intent = Intent(this, KrNosBezApteczki::class.java)
            startActivity(intent)
        }

        wrocA4.setOnClickListener {
            val intent = Intent(this, KrBezpiecznie::class.java)
            startActivity(intent)
        }

        domowaA4.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

    }
}