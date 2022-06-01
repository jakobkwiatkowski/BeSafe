package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrBezpiecznie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_bezpiecznie)

        val krznosa = findViewById<Button>(R.id.buttonczyjesttak2)
        val krnieznosa = findViewById<Button>(R.id.buttonczyjestnie2)
        //val wrocA3 = findViewById<ImageView>(R.id.wrocA3)
        //val domowaA3 = findViewById<ImageView>(R.id.domowaA3)

        krznosa.setOnClickListener {
            val intent = Intent(this, KrZNosa::class.java)
            startActivity(intent)
        }

        krnieznosa.setOnClickListener {
            val intent = Intent(this, KrNieZNosa::class.java)
            startActivity(intent)
        }

        //wrocA3.setOnClickListener {
        // val intent = Intent(this, KrCzyBezpiecznie::class.java)
        // startActivity(intent)
        //}

        //domowaA3.setOnClickListener {
        //  val intent = Intent(this, StartActivity::class.java)
        //  startActivity(intent)
        //}

    }
}