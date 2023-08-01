package com.macrogallant.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*

class TemperatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        val input: EditText = findViewById(R.id.et_input)
        val result: TextView = findViewById(R.id.result)
        val celsius = findViewById<CheckBox>(R.id.celsius)
        val kelvin = findViewById<CheckBox>(R.id.kelvin)
        val fahrenheit = findViewById<CheckBox>(R.id.fahrenheit)
        val celsius1 = findViewById<CheckBox>(R.id.celsius1)
        val kelvin1 = findViewById<CheckBox>(R.id.kelvin1)
        val fahrenheit1 = findViewById<CheckBox>(R.id.fahrenheit1)
        val submitBtn = findViewById<Button>(R.id.submit)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        celsius.setOnClickListener{
            celsius.isChecked = true
            kelvin.isChecked = false
            fahrenheit.isChecked = false
        }
        kelvin.setOnClickListener{
            celsius.isChecked = false
            kelvin.isChecked = true
            fahrenheit.isChecked = false
        }
        fahrenheit.setOnClickListener{
            celsius.isChecked = false
            kelvin.isChecked = false
            fahrenheit.isChecked = true
        }
        celsius1.setOnClickListener{
            celsius1.isChecked = true
            kelvin1.isChecked = false
            fahrenheit1.isChecked = false
        }
        kelvin1.setOnClickListener{
            celsius1.isChecked = false
            kelvin1.isChecked = true
            fahrenheit1.isChecked = false
        }
        fahrenheit1.setOnClickListener{
            celsius1.isChecked = false
            kelvin1.isChecked = false
            fahrenheit1.isChecked = true
        }

        submitBtn.setOnClickListener {
            if (input.text.isEmpty()) {
                Toast.makeText(this, "Please enter value", Toast.LENGTH_SHORT).show()
            } else {
                result.text = "0"
                if (kelvin.isChecked && celsius1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() - 273.15
                    result.text = "$answer Celsius"

                } else if (celsius.isChecked && kelvin1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() + 273.15
                    result.text = "$answer Kelvin"

                } else if (celsius.isChecked && fahrenheit1.isChecked) {
                    val answer = (input.text.toString().toInt().toDouble() * 9 / 5) + 32
                    result.text = "$answer Fahrenheit"

                } else if (kelvin.isChecked && fahrenheit1.isChecked) {
                    val answer = (input.text.toString().toInt().toDouble() - 273.15) * 1.8 + 32
                    result.text = "$answer Fahrenheit"

                } else if (fahrenheit.isChecked && celsius1.isChecked) {
                    val answer = (input.text.toString().toInt().toDouble() - 32) * 5 / 9
                    result.text = "$answer Celsius"

                } else if (fahrenheit.isChecked && kelvin1.isChecked) {
                    val answer =
                        273.5 + ((input.text.toString().toInt().toDouble() - 32.0) * (5.0 / 9.0))
                    result.text = "$answer Kelvin"
                } else if (celsius.isChecked && celsius1.isChecked) {
                    Toast.makeText(this, "Please select another option", Toast.LENGTH_SHORT).show()
                } else if (kelvin.isChecked && kelvin1.isChecked) {
                    Toast.makeText(this, "Please select another option", Toast.LENGTH_SHORT).show()
                } else if (fahrenheit.isChecked && fahrenheit1.isChecked) {
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