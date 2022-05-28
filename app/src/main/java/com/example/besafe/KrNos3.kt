package com.example.besafe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class KrNos3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_nos3)

        val pomoc = findViewById<Button>(R.id.NosPomoc)

        pomoc.setOnClickListener {
            val numer = "112"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }
    }
}