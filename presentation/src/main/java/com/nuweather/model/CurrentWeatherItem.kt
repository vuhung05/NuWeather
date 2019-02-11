package com.nuweather.model

import com.nuweather.base.ItemMapper
import com.nuweather.base.ModelItem
import com.nuweather.domain.model.CurrentWeather
import com.nuweather.domain.model.Sys
import com.nuweather.domain.model.Wind

data class CurrentWeatherItem(
    val id: Int,
    val description: String,
    val temp: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val visibility: Int,
    val clouds: Int,
    val wind: WindItem,
    val sys: SysItem,
    val dt: Int
) : ModelItem()

data class WindItem(
    val speed: Double,
    val deg: Int
) : ModelItem()


data class SysItem(
    val type: Int,
    val id: Int,
    val message: Double,
    val country: String,
    val sunrise: Int,
    val sunset: Int
) : ModelItem()

class CurrentWeatherMapper constructor(
    private val windMapper: WindMapper,
    private val sysMapper: SysMapper
) : ItemMapper<CurrentWeather, CurrentWeatherItem> {
    override fun mapToPresentation(model: CurrentWeather) = CurrentWeatherItem(
        id = model.id,
        description = model.description,
        temp = model.temp,
        tempMin = model.tempMin,
        tempMax = model.tempMax,
        pressure = model.pressure,
        visibility = model.visibility,
        clouds = model.clouds,
        wind = windMapper.mapToPresentation(model.wind),
        sys = sysMapper.mapToPresentation(model.sys),
        dt = model.dt
    )

    override fun mapToDomain(modelItem: CurrentWeatherItem) = CurrentWeather(
        id = modelItem.id,
        description = modelItem.description,
        temp = modelItem.temp,
        tempMin = modelItem.tempMin,
        tempMax = modelItem.tempMax,
        pressure = modelItem.pressure,
        visibility = modelItem.visibility,
        clouds = modelItem.clouds,
        wind = windMapper.mapToDomain(modelItem.wind),
        sys = sysMapper.mapToDomain(modelItem.sys),
        dt = modelItem.dt
    )

}

class WindMapper : ItemMapper<Wind, WindItem> {
    override fun mapToPresentation(model: Wind) = WindItem(
        speed = model.speed,
        deg = model.deg
    )

    override fun mapToDomain(modelItem: WindItem) = Wind(
        speed = modelItem.speed,
        deg = modelItem.deg
    )
}

class SysMapper : ItemMapper<Sys, SysItem> {
    override fun mapToPresentation(model: Sys) = SysItem(
        type = model.type,
        id = model.id,
        message = model.message,
        country = model.country,
        sunrise = model.sunrise,
        sunset = model.sunset
    )

    override fun mapToDomain(modelItem: SysItem) = Sys(
        type = modelItem.type,
        id = modelItem.id,
        message = modelItem.message,
        country = modelItem.country,
        sunrise = modelItem.sunrise,
        sunset = modelItem.sunset
    )
}