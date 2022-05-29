package com.example.besafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog


class DodInfo : AppCompatActivity() {

    private var rozmowaInfo: Button? = null
    private var srodkiInfo: Button? = null
    private var domowa: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dod_info)

        rozmowaInfo = findViewById(R.id.buttonRozmowa)
        srodkiInfo = findViewById(R.id.buttonSrodkiOchr)
        domowa = findViewById(R.id.domowa)

        rozmowaInfo?.setOnClickListener {
            val mDialogView =
                LayoutInflater.from(this).inflate(R.layout.activity_rozmowa_pop_up, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("JAK WEZWAĆ SŁUŻBY?")

            val mAlertDialog = mBuilder.show()
            val btZamknij = mAlertDialog.findViewById<ImageView>(R.id.zamknij)
            btZamknij?.setOnClickListener { mAlertDialog.dismiss() }
        }

        srodkiInfo?.setOnClickListener {
            val mDialogView =
                LayoutInflater.from(this).inflate(R.layout.activity_srodki_pop_up, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("STOSOWANIE SPRZĘTU OCHRONY DRÓG ODDECHOWYCH")

            val mAlertDialog = mBuilder.show()
            val btZamknij = mAlertDialog.findViewById<ImageView>(R.id.zamknij2)
            btZamknij?.setOnClickListener { mAlertDialog.dismiss() }
        }

        domowa?.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

    }
}