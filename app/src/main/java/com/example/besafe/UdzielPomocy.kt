package com.example.besafe

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class UdzielPomocy : AppCompatActivity(), TextToSpeech.OnInitListener {

    //private var domowa2: ImageView? = null
    private var tts: TextToSpeech? = null
    private var btnSpeak: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_udziel_pomocy)

        val buttonKrwotok = findViewById<Button>(R.id.ButtonKrwotok)
        buttonKrwotok.setOnClickListener {
            val intent = Intent(this, KrCzyBezpiecznie::class.java)
            startActivity(intent)
        }

        //domowa2 = findViewById(R.id.domowa2)
        //domowa2?.setOnClickListener {
        // val intent = Intent(this, StartActivity::class.java)
        //startActivity(intent)
        // }

        btnSpeak = findViewById(R.id.speaker)

        btnSpeak!!.isEnabled = false

        // TextToSpeech(Context: this, OnInitListener: this)
        tts = TextToSpeech(this, this)

        btnSpeak!!.setOnClickListener { speakOut() }

    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            //val result = tts!!.setLanguage(Locale.US)
            val result = tts!!.setLanguage(Locale("pl", "PL"))

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The Language not supported!")
            } else {
                btnSpeak!!.isEnabled = true
            }
        }
    }

    private fun speakOut() {
        val text =
            "Zidentyfikuj sytuację zagrożenia, w której się znalazłeś. Postępując według dalszych instrukcji, bedziesz w stanie udzielić pierwszej pomocy lub wezwać służby ratunkowe."
        tts!!.setSpeechRate(0.85f);
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    public override fun onDestroy() {
        // Shutdown TTS when
        // activity is destroyed
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }

}