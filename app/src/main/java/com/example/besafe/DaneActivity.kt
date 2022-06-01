package com.example.besafe

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.database.*


class DaneActivity : AppCompatActivity() {

    //private var domowa: ImageView? = null
    private var wprowadz: Button? = null
    private var ICEpokaz: TextView? = null
    private var lekiPokaz: TextView? = null
    private var chorobyPokaz: TextView? = null
    private var grupaKrwiPokaz: TextView? = null
    private var zadzwonICE: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dane)

        val phone = intent.getStringExtra("phone")

        ICEpokaz = findViewById(R.id.textView8)
        lekiPokaz = findViewById(R.id.textView10)
        chorobyPokaz = findViewById(R.id.textView12)
        grupaKrwiPokaz = findViewById(R.id.textView14)
        //domowa = findViewById(R.id.domowaA15)
        wprowadz = findViewById(R.id.buttonWprowadz)
        zadzwonICE = findViewById(R.id.dzwonICEbutton)
        zadzwonICE?.isEnabled = false

        wprowadz?.setOnClickListener {
            val intent = Intent(this@DaneActivity, DaneWprowadzActivity::class.java)
            intent.putExtra("phone", phone)
            startActivity(intent)
        }

        // domowa?.setOnClickListener {
        //   val intent = Intent(this, StartActivity::class.java)
        //   startActivity(intent)
        // }

        val databaseReference: DatabaseReference = FirebaseDatabase.getInstance()
            .getReferenceFromUrl("https://besafe-ecb67-default-rtdb.europe-west1.firebasedatabase.app/users/$phone")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            @SuppressLint("SetTextI18n")
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    val ice = snapshot.child("numer ICE").value.toString()
                    if (ice.equals(null) || ice.isEmpty() || ice == "null") {
                        ICEpokaz?.text = "Brak informacji"
                    } else {
                        ICEpokaz?.text = ice
                        zadzwonICE?.isEnabled = true
                        zadzwonICE?.setOnClickListener {
                            val numer = ICEpokaz?.text.toString()
                            //Dialer intent
                            val intent =
                                Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(numer)))
                            startActivity(intent)
                        }
                    }
                } else {
                    ICEpokaz?.text = "Brak informacji"
                }

                if (snapshot.exists()) {
                    val leki = snapshot.child("przyjmowane leki").value.toString()
                    if (leki.equals(null) || leki.isEmpty() || leki == "null") {
                        lekiPokaz?.text = "Brak informacji"
                    } else {
                        lekiPokaz?.text = leki
                    }
                } else {
                    lekiPokaz?.text = "Brak informacji"
                }

                if (snapshot.exists()) {
                    val choroby = snapshot.child("przewlekłe choroby").value.toString()
                    if (choroby.equals(null) || choroby.isEmpty() || choroby == "null") {
                        chorobyPokaz?.text = "Brak informacji"
                    } else {
                        chorobyPokaz?.text = choroby
                    }
                } else {
                    chorobyPokaz?.text = "Brak informacji"
                }

                if (snapshot.exists()) {
                    val grupaKrwi = snapshot.child("grupa krwi").value.toString()
                    if (grupaKrwi.equals(null) || grupaKrwi.isEmpty() || grupaKrwi == "null") {
                        grupaKrwiPokaz?.text = "Brak informacji"
                    } else {
                        grupaKrwiPokaz?.text = grupaKrwi
                    }
                } else {
                    grupaKrwiPokaz?.text = "Brak informacji"
                }
            }
        })
    }
}



