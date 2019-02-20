package com.nuweather.model

import com.nuweather.base.ModelItem

data class WeatherItem(
    val id: Long,
    val city: String,
    val description: String,
    val temp: Int,
    val tempMin: Int,
    val tempMax: Int,
    val pressure: Double,
    val visibility: Double,
    val humidity: Double,
    val clouds: Double,
    val wind: WindItem,
    val sys: SysItem,
    val dt: Long
) : ModelItem()