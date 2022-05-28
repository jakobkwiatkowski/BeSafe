package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrNosApteczka : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_nos_apteczka)

        val dalej = findViewById<Button>(R.id.Dalej)

        dalej.setOnClickListener {
            val intent = Intent(this, KrNos2::class.java)
            startActivity(intent)
        }
    }
}