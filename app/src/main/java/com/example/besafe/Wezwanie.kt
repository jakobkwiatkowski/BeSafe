package com.example.besafe

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.RadioButton

class Wezwanie : AppCompatActivity() {

    private var numer112: RadioButton? = null
    private var numer999: RadioButton? = null
    private var numer998: RadioButton? = null
    private var numer997: RadioButton? = null
    private var numer986: RadioButton? = null
    private var numer991: RadioButton? = null
    private var numer993: RadioButton? = null
    private var numer994: RadioButton? = null
    private var numer992: RadioButton? = null
    private var zKontakty: RadioButton? = null
    private var innyNumer: RadioButton? = null
    private var domowa: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wezwanie)

        numer112 = findViewById(R.id.radioButton112)
        numer999 = findViewById(R.id.radioButton999)
        numer998 = findViewById(R.id.radioButton998)
        numer997 = findViewById(R.id.radioButton997)
        numer986 = findViewById(R.id.radioButton986)
        numer991 = findViewById(R.id.radioButton991)
        numer993 = findViewById(R.id.radioButton993)
        numer994 = findViewById(R.id.radioButton994)
        numer992 = findViewById(R.id.radioButton992)
        zKontakty = findViewById(R.id.radioButtonKontakty)
        innyNumer = findViewById(R.id.radioButtonInnyNr)
        domowa = findViewById(R.id.imageView11)

        numer112?.setOnClickListener {
            val numer = "112"
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }

        numer999?.setOnClickListener {
            val numer = "999"
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }

        numer998?.setOnClickListener {
            val numer = "998"
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }

        numer997?.setOnClickListener {
            val numer = "997"
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }

        numer986?.setOnClickListener {
            val numer = "986"
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }

        numer991?.setOnClickListener {
            val numer = "991"
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }

        numer993?.setOnClickListener {
            val numer = "993"
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }

        numer994?.setOnClickListener {
            val numer = "994"
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }

        numer992?.setOnClickListener {
            val numer = "992"
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
            startActivity(intent)
        }

        zKontakty?.setOnClickListener {
            //Dialer intent
            val intent = Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)
        }

        innyNumer?.setOnClickListener {
            //Dialer intent
            val intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }

        domowa?.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

    }
}