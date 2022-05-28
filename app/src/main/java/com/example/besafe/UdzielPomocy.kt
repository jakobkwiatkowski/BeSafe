package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UdzielPomocy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_udziel_pomocy)

        val buttonKrwotok = findViewById<Button>(R.id.ButtonKrwotok)
        buttonKrwotok.setOnClickListener {
            val intent = Intent(this, KrCzyBezpiecznie::class.java)
            startActivity(intent)
        }
    }



}