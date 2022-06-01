package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrBezApteczki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_bez_apteczki)

        val dalej = findViewById<Button>(R.id.dalej5)
        //val wrocA13 = findViewById<ImageView>(R.id.wrocA13)
       // val domowaA13 = findViewById<ImageView>(R.id.domowaA13)

        dalej.setOnClickListener {
            val intent = Intent(this, KrBez2::class.java)
            startActivity(intent)
        }

        //wrocA13.setOnClickListener {
        // val intent = Intent(this, KrNieZNosa::class.java)
        //startActivity(intent)
        // }

        // domowaA13.setOnClickListener {
        //  val intent = Intent(this, StartActivity::class.java)
        // startActivity(intent)
        //}

    }
}