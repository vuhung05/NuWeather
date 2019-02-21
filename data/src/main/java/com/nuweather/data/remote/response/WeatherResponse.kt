package com.nuweather.data.remote.response

import com.google.gson.annotations.SerializedName
import com.nuweather.data.model.SysEntity
import com.nuweather.data.model.WeatherEntity
import com.nuweather.data.model.WindEntity
import com.nuweather.data.remote.response.base.BaseResponse
import com.nuweather.data.remote.response.model.*
import java.util.*


data class WeatherResponse(
    @SerializedName("coord") val coord: Coord,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("base") val base: String,
    @SerializedName("main") val main: Main,
    @SerializedName("visibility") val visibility: Int?,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("dt") val dt: Long,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("id") val id: Double,
    @SerializedName("name") val name: String,
    @SerializedName("cod") val cod: Int,
    @SerializedName("dt_txt") val dtTxt: String
) : BaseResponse() {

    override fun mapToEntity() = WeatherEntity(
        id = weather[0].id,
        city = "$name, ${sys.country}",
        description = weather[0].description,
        temp = (main.temp - 273).toInt(),
        temp_min = (main.tempMin - 273).toInt(),
        temp_max = (main.tempMax - 273).toInt(),
        pressure = main.pressure,
        visibility = visibility,
        humidity = main.humidity,
        clouds = clouds.all,
        wind = WindEntity(wind.speed, wind.deg),
        sys = SysEntity(sys.type, sys.id, sys.message, sys.country, sys.sunrise, sys.sunset),
        dt = Date(dt * 1000)
    )
}