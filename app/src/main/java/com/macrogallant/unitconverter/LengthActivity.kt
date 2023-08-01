package com.macrogallant.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*

class LengthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_length)

        val input: EditText = findViewById(R.id.et_input)
        val result: TextView = findViewById(R.id.result)
        val meter = findViewById<CheckBox>(R.id.meter)
        val kilometer = findViewById<CheckBox>(R.id.kilometer)
        val centimeter = findViewById<CheckBox>(R.id.centimeter)
        val meter1 = findViewById<CheckBox>(R.id.meter1)
        val kilometer1 = findViewById<CheckBox>(R.id.kilometer1)
        val centimeter1 = findViewById<CheckBox>(R.id.centimeter1)
        val submitBtn = findViewById<Button>(R.id.submit)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        meter.setOnClickListener{
            meter.isChecked = true
            kilometer.isChecked = false
            centimeter.isChecked = false
        }
        kilometer.setOnClickListener{
            meter.isChecked = false
            kilometer.isChecked = true
            centimeter.isChecked = false
        }
        centimeter.setOnClickListener{
            meter.isChecked = false
            kilometer.isChecked = false
            centimeter.isChecked = true
        }

        meter1.setOnClickListener{
            meter1.isChecked = true
            kilometer1.isChecked = false
            centimeter1.isChecked = false
        }
        kilometer1.setOnClickListener{
            meter1.isChecked = false
            kilometer1.isChecked = true
            centimeter1.isChecked = false
        }
        centimeter1.setOnClickListener{
            meter1.isChecked = false
            kilometer1.isChecked = false
            centimeter1.isChecked = true
        }

        submitBtn.setOnClickListener {
            if (input.text.isEmpty()) {
                Toast.makeText(this, "Please enter value", Toast.LENGTH_SHORT).show()
            } else {
                result.text = "0"
                if (kilometer.isChecked && meter1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() * 1000
                    result.text = "$answer meter"

                } else if (meter.isChecked && kilometer1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() / 1000
                    result.text = "$answer Kilometer"

                } else if (meter.isChecked && centimeter1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() * 100
                    result.text = "$answer Centimeter"

                } else if (kilometer.isChecked && centimeter1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() * 100000
                    result.text = "$answer Centimeter"

                } else if (centimeter.isChecked && meter1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() * 0.01
                    result.text = "$answer Meter"

                } else if (centimeter.isChecked && kilometer1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() / 100000
                    result.text = "$answer Kilometer"
                } else if (meter.isChecked && meter1.isChecked) {
                    Toast.makeText(this, "Please select another option", Toast.LENGTH_SHORT).show()
                } else if (kilometer.isChecked && kilometer1.isChecked) {
                    Toast.makeText(this, "Please select another option", Toast.LENGTH_SHORT).show()
                } else if (centimeter.isChecked && centimeter1.isChecked) {
                    Toast.makeText(this, "Please select another option", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}