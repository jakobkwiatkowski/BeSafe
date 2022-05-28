package com.example.besafe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class StartActivity : AppCompatActivity() {

    private var wyjdz: TextView? = null
    private var wezwijPomoc: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        wyjdz = findViewById(R.id.wyjdzButton)
        wezwijPomoc = findViewById(R.id.wezwijPomocButton)

        wyjdz?.setOnClickListener {

            finish()

            Toast.makeText(
                this,
                "Zaloguj się ponownie",
                Toast.LENGTH_SHORT
            )
                .show()

            val intent = Intent(this, LogowanieActivity::class.java)
            startActivity(intent)
        }

        wezwijPomoc?.setOnClickListener {

            val intent = Intent(this, Wezwanie::class.java)
            startActivity(intent)

        }
    }
}