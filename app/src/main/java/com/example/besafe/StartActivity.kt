package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class StartActivity : AppCompatActivity() {

    private var wezwijPomoc: Button? = null
    private var udzielPomoc: Button? = null
    private var twojeDane: Button? = null
    private var dodInfo: Button? = null
    private var wyjdz: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val phone = intent.getStringExtra("phone")

        udzielPomoc = findViewById(R.id.udzielPomocyButton)
        wezwijPomoc = findViewById(R.id.wezwijPomocButton)
        twojeDane = findViewById(R.id.twojeBezpieczenstwoButton)
        dodInfo = findViewById(R.id.dodatkoweInformacjeButton)
        wyjdz = findViewById(R.id.wyjdzButton)

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

        udzielPomoc?.setOnClickListener {
            val intent = Intent(this, UdzielPomocy::class.java)
            startActivity(intent)
        }

        twojeDane?.setOnClickListener {
            val intent = Intent(this@StartActivity, DaneActivity::class.java)
            intent.putExtra("phone", phone)
            startActivity(intent)
        }

        dodInfo?.setOnClickListener {
            val intent = Intent(this, DodInfo::class.java)
            startActivity(intent)
        }

    }
}