package com.nuweather.domain.model

data class CurrentWeather(
        val id: Int,
        val description: String,
        val temp: Double,
        val temp_min: Double,
        val temp_max: Double,
        val pressure: Int,
        val visibility: Int,
        val clouds: Int,
        val wind: Wind,
        val sys: Sys,
        val dt: Int
) : Model()

data class Wind(
        val speed: Double,
        val deg: Int
) : Model()


data class Sys(
        val type: Int,
        val id: Int,
        val message: Double,
        val country: String,
        val sunrise: Int,
        val sunset: Int
) : Model()
