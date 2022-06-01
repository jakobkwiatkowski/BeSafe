package com.example.besafe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class DaneWprowadzActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    var grupyKrwi =
        arrayOf("0 Rh+", "A Rh+", "B Rh+", "AB Rh+", "0 Rh-", "A Rh-", "B Rh-", "AB Rh-")
    var spinner: Spinner? = null
    // private var wstecz: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dane_wprowadz)

        spinner = this.findViewById(R.id.spinnerGrupaKrwi)
        spinner!!.setOnItemSelectedListener(this)
        // Create an ArrayAdapter using a simple spinner layout and array
        val aa = ArrayAdapter(this, R.layout.spinner_list, grupyKrwi)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(R.layout.spinner_list)
        // Set Adapter to Spinner
        spinner!!.setAdapter(aa)

        val zapiszButton = findViewById<Button>(R.id.zapiszButton)
        zapiszButton.setOnClickListener {
            val databaseReference: DatabaseReference = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://besafe-ecb67-default-rtdb.europe-west1.firebasedatabase.app/")

            val phone = intent.getStringExtra("phone")

            val ICEInput = findViewById<EditText>(R.id.ICEInput)
            val lekiInput = findViewById<EditText>(R.id.lekiInput)
            val chorobyInput = findViewById<EditText>(R.id.chorobyInput)
            val grupaKrwiInput = spinner?.getSelectedItem()

            val icetxt = ICEInput.text.toString().trim()
            val lekitxt = lekiInput.text.toString().trim()
            val chorobytxt = chorobyInput.text.toString().trim()
            val grupaKrwitxt = grupaKrwiInput.toString().trim()

            when {

                (icetxt.isEmpty() || lekitxt.isEmpty() || chorobytxt.isEmpty() || grupaKrwitxt.isEmpty()) -> {
                    Toast.makeText(this, "Proszę wypełnić wszystkie pola", Toast.LENGTH_SHORT)
                        .show()
                }

                (!icetxt.replace("\\s".toRegex(), "").isDigitsOnly()) -> {
                    Toast.makeText(
                        this,
                        "Numer telefonu powinien składać się wyłącznie z cyfr",
                        Toast.LENGTH_SHORT
                    ).show()
                    ICEInput.text.clear()
                }

                else -> {

                    if (phone != null) {
                        databaseReference.child("users").child(phone).child("numer ICE")
                            .setValue(icetxt)
                    }
                    if (phone != null) {
                        databaseReference.child("users").child(phone).child("przyjmowane leki")
                            .setValue(lekitxt)
                    }
                    if (phone != null) {
                        databaseReference.child("users").child(phone).child("przewlekłe choroby")
                            .setValue(chorobytxt)
                    }
                    if (phone != null) {
                        databaseReference.child("users").child(phone).child("grupa krwi")
                            .setValue(grupaKrwitxt)
                    }

                    val intent = Intent(this@DaneWprowadzActivity, DaneActivity::class.java)
                    intent.putExtra("phone", phone)
                    startActivity(intent)

                    Toast.makeText(this, "Dane zostały zapisane", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }

        //wstecz = findViewById(R.id.wroc)
        //wstecz?.setOnClickListener {
        // val intent = Intent(this, DaneActivity::class.java)
        // startActivity(intent)
        //}

    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {

        // val toast = Toast.makeText(this, "Wskaż grupę krwi z listy", Toast.LENGTH_SHORT)
        // toast.setGravity(Gravity.BOTTOM, 0, 350)
        // toast.show()

    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

        // val toast = Toast.makeText(this, "Wskaż grupę krwi z listy", Toast.LENGTH_SHORT)
        // toast.setGravity(Gravity.BOTTOM, 0, 350)
        // toast.show()

    }

}