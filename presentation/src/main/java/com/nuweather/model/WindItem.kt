package com.nuweather.model

import com.nuweather.base.ModelItem

data class WindItem(
    val speed: Double,
    val deg: Double
) : ModelItem()
