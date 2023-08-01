package com.macrogallant.unitconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.macrogallant.adapter.CardAdapter
import com.macrogallant.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gridRecycler.layoutManager = GridLayoutManager(this,2)
        binding.gridRecycler.adapter = CardAdapter(this, com.macrogallant.const.Layout.GRID)
        binding.gridRecycler.setHasFixedSize(true)

    }
}