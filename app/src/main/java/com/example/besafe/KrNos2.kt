package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrNos2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_nos2)

        val dalej = findViewById<Button>(R.id.dalej3)
        //val wrocA6 = findViewById<ImageView>(R.id.wrocA6)
        //val domowaA6 = findViewById<ImageView>(R.id.domowaA6)


        dalej.setOnClickListener {
            val intent = Intent(this, KrNos3::class.java)
            startActivity(intent)
        }

        //wrocA6.setOnClickListener {
        //val intent = Intent(this, KrZNosa::class.java)
        //startActivity(intent)
        //}

        //domowaA6.setOnClickListener {
        // val intent = Intent(this, StartActivity::class.java)
        // startActivity(intent)
        //}

    }
}