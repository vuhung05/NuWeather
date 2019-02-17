package com.nuweather.domain.model

data class CurrentWeather(
    val id: Long,
    val description: String,
    val temp: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Double,
    val visibility: Double,
    val clouds: Double,
    val wind: Wind,
    val sys: Sys,
    val dt: Long
) : Model()

data class Wind(
    val speed: Double,
    val deg: Double
) : Model()


data class Sys(
    val type: Int,
    val id: Long,
    val message: Double,
    val country: String,
    val sunrise: Long,
    val sunset: Long
) : Model()
