package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrCzyBezpiecznie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_czy_bezpiecznie)

        val czyjesttak = findViewById<Button>(R.id.buttonczyjesttak)
        val czyjestnie = findViewById<Button>(R.id.buttonczyjestnie)
        val wrocA = findViewById<ImageView>(R.id.wrocA)
        val domowaA = findViewById<ImageView>(R.id.domowaA)

        czyjesttak.setOnClickListener {
            val intent = Intent(this, KrBezpiecznie::class.java)
            startActivity(intent)
        }

        czyjestnie.setOnClickListener {
            val intent = Intent(this, KrNiebezpiecznie::class.java)
            startActivity(intent)
        }

        wrocA.setOnClickListener {
            val intent = Intent(this, UdzielPomocy::class.java)
            startActivity(intent)
        }

        domowaA.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

    }
}