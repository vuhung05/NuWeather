package com.nuweather.data.model

import com.nuweather.data.base.Entity

data class WindEntity(
    val speed: Double,
    val deg: Double
) : Entity()
