package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrNieZNosa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_nie_znosa)

        val jestapteczka = findViewById<Button>(R.id.buttonczyjesttak3)
        val niemaapteczki = findViewById<Button>(R.id.buttonczyjestnie3)
        //val wrocA9 = findViewById<ImageView>(R.id.wrocA9)
        //val domowaA9 = findViewById<ImageView>(R.id.domowaA9)

        jestapteczka.setOnClickListener {
            val intent = Intent(this, KrApteczka::class.java)
            startActivity(intent)
        }

        niemaapteczki.setOnClickListener {
            val intent = Intent(this, KrBezApteczki::class.java)
            startActivity(intent)
        }

        //wrocA9.setOnClickListener {
        // val intent = Intent(this, KrBezpiecznie::class.java)
        //startActivity(intent)
        // }

        //domowaA9.setOnClickListener {
        //  val intent = Intent(this, StartActivity::class.java)
        // startActivity(intent)
        // }

    }
}