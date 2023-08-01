package com.macrogallant.model

import androidx.annotation.DrawableRes

data class Name(
    @DrawableRes val imageResId: Int,
    val name: String,
)
