package com.example.besafe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class KrApteczka3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kr_apteczka3)

        val pomoc = findViewById<Button>(R.id.krPomoc)
        val wrocA12 = findViewById<ImageView>(R.id.wrocA12)
        val domowaA12 = findViewById<ImageView>(R.id.domowaA12)

        pomoc.setOnClickListener {
            val numer = "112"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }
        
        wrocA12.setOnClickListener {
            val intent = Intent(this, KrApteczka2::class.java)
            startActivity(intent)
        }

        domowaA12.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

    }
}