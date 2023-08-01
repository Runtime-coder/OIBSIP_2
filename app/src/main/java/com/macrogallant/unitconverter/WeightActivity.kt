package com.macrogallant.unitconverter

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class WeightActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weight)

        val input: EditText = findViewById(R.id.et_input)
        val result: TextView = findViewById(R.id.result)
        val kilogram = findViewById<CheckBox>(R.id.kilogram)
        val gram = findViewById<CheckBox>(R.id.gram)
        val milligram = findViewById<CheckBox>(R.id.milligram)
        val kilogram1 = findViewById<CheckBox>(R.id.kilogram1)
        val gram1 = findViewById<CheckBox>(R.id.gram1)
        val milligram1 = findViewById<CheckBox>(R.id.milligram1)
        val submitBtn = findViewById<Button>(R.id.submit)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        kilogram.setOnClickListener{
            kilogram.isChecked = true
            gram.isChecked = false
            milligram.isChecked = false
        }
        gram.setOnClickListener{
            kilogram.isChecked = false
            gram.isChecked = true
            milligram.isChecked = false
        }
        milligram.setOnClickListener{
            kilogram.isChecked = false
            gram.isChecked = false
            milligram.isChecked = true
        }

        kilogram1.setOnClickListener{
            kilogram1.isChecked = true
            gram1.isChecked = false
            milligram1.isChecked = false
        }
        gram1.setOnClickListener{
            kilogram1.isChecked = false
            gram1.isChecked = true
            milligram1.isChecked = false
        }
        milligram1.setOnClickListener{
            kilogram1.isChecked = false
            gram1.isChecked = false
            milligram1.isChecked = true
        }

        submitBtn.setOnClickListener {
            if (input.text.isEmpty()) {
                Toast.makeText(this, "Please enter value", Toast.LENGTH_SHORT).show()
            } else {
                result.text = "0"
                if (gram.isChecked && kilogram1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() / 1000
                    result.text = "$answer Kilogram"
                } else if (kilogram.isChecked && gram1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() * 1000
                    result.text = "$answer Gram"
                } else if (kilogram.isChecked && milligram1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() * 1000000
                    result.text = "$answer Milligram"
                } else if (gram.isChecked && milligram1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() * 1000
                    result.text = "$answer Milligram"
                } else if (milligram.isChecked && kilogram1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() / 1e+6
                    result.text = "$answer Kilogram"
                } else if (milligram.isChecked && gram1.isChecked) {
                    val answer = input.text.toString().toInt().toDouble() / 1000
                    result.text = "$answer Gram"
                } else if (kilogram.isChecked && kilogram1.isChecked) {
                    Toast.makeText(this, "Please select another option", Toast.LENGTH_SHORT).show()
                } else if (gram.isChecked && gram1.isChecked) {
                    Toast.makeText(this, "Please select another option", Toast.LENGTH_SHORT).show()
                } else if (milligram.isChecked && milligram1.isChecked) {
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



