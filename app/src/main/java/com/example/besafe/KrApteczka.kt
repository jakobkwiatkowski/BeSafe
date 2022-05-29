package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrApteczka : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_apteczka)

        val dalej = findViewById<Button>(R.id.dalej2)
        val wrocA10 = findViewById<ImageView>(R.id.wrocA10)
        val domowaA10 = findViewById<ImageView>(R.id.domowaA10)

        dalej.setOnClickListener {
            val intent = Intent(this, KrApteczka2::class.java)
            startActivity(intent)
        }

        wrocA10.setOnClickListener {
            val intent = Intent(this, KrNieZNosa::class.java)
            startActivity(intent)
        }

        domowaA10.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

    }
}