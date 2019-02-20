package com.nuweather.domain.model

data class Sys(
    val type: Int,
    val id: Long,
    val message: Double,
    val country: String,
    val sunrise: Long,
    val sunset: Long
) : Model()
