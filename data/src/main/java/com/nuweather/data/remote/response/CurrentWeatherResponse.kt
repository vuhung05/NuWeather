package com.nuweather.data.remote.response

import com.google.gson.annotations.SerializedName
import com.nuweather.data.model.SysEntity
import com.nuweather.data.model.WeatherEntity
import com.nuweather.data.model.WindEntity


data class CurrentWeatherResponse(
    @SerializedName("coord") val coord: Coord,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("base") val base: String,
    @SerializedName("main") val main: Main,
    @SerializedName("visibility") val visibility: Double,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("dt") val dt: Long,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("id") val id: Double,
    @SerializedName("name") val name: String,
    @SerializedName("cod") val cod: Int
) : BaseResponse() {

    fun mapToEntity() = WeatherEntity(
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
        dt = dt
    )
}

data class Sys(
    @SerializedName("type") val type: Int,
    @SerializedName("id") val id: Long,
    @SerializedName("message") val message: Double,
    @SerializedName("country") val country: String,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long
)


data class Coord(
    @SerializedName("lon") val lon: Double,
    @SerializedName("lat") val lat: Double
)


data class Main(
    @SerializedName("temp") val temp: Double,
    @SerializedName("pressure") val pressure: Double,
    @SerializedName("humidity") val humidity: Double,
    @SerializedName("tempMin") val tempMin: Double,
    @SerializedName("tempMax") val tempMax: Double
)


data class Weather(
    @SerializedName("id") val id: Long,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)


data class Clouds(
    @SerializedName("all") val all: Double
)


data class Wind(
    @SerializedName("speed") val speed: Double,
    @SerializedName("deg") val deg: Double
)