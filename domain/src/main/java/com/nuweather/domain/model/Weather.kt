package com.nuweather.domain.model

import java.util.*

data class Weather(
    val id: Long,
    val city: String,
    val description: String,
    val temp: Int,
    val tempMin: Int,
    val tempMax: Int,
    val pressure: Double,
    val visibility: Int?,
    val humidity: Int,
    val clouds: Int,
    val wind: Wind,
    val sys: Sys,
    val dt: Date
) : Model()