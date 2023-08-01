package com.macrogallant.data

import com.macrogallant.model.Name
import com.macrogallant.unitconverter.R

object DataSource {
    val names: List<Name> = listOf(
        Name(
            R.drawable.weight,
            "Weight",
        ),
        Name(
            R.drawable.length,
            "Length",

        ),
        Name(
            R.drawable.temperature,
            "Temperature",
        )
    )
}