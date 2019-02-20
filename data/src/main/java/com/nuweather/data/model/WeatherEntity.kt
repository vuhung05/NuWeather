package com.nuweather.data.model

import com.nuweather.data.base.Entity

data class WeatherEntity(
    val id: Long,
    val city: String,
    val description: String,
    val temp: Int,
    val temp_min: Int,
    val temp_max: Int,
    val pressure: Double,
    val visibility: Double,
    val humidity: Double,
    val clouds: Double,
    val wind: WindEntity,
    val sys: SysEntity,
    val dt: Long
) : Entity()
