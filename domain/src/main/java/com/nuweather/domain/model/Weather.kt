package com.nuweather.domain.model

data class Weather(
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
    val wind: Wind,
    val sys: Sys,
    val dt: Long
) : Model()