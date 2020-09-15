package com.rjoshi.rjoshiroz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private var spinner: Spinner? = null
    private var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinnerCountries)
        spinner!!.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            CountryData.countryNames
        )
        editText = findViewById(R.id.editTextPhone)
        findViewById<Button>(R.id.buttonContinue).setOnClickListener(View.OnClickListener {
            val code: String = CountryData.countryAreaCodes[spinner!!.selectedItemPosition]
            val number = editText!!.getText().toString().trim { it <= ' ' }
            if (number.isEmpty() || number.length < 10) {
                editText!!.error = "Invalid Number"
                editText!!.requestFocus()
                return@OnClickListener
            }
            val phoneNumber = "+$code$number"
            val intent = Intent(this@MainActivity, phoneVerificationActivity::class.java)
            intent.putExtra("phonenumber", phoneNumber)
            startActivity(intent)
        })
    }

    override fun onStart() {
        super.onStart()
        if (FirebaseAuth.getInstance().currentUser != null) {
            val intent = Intent(this, dashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}