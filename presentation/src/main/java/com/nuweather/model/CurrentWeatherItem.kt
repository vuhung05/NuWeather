package com.nuweather.model

import com.nuweather.base.ItemMapper
import com.nuweather.base.ModelItem
import com.nuweather.domain.model.CurrentWeather
import com.nuweather.domain.model.Model
import com.nuweather.domain.model.Sys
import com.nuweather.domain.model.Wind
import javax.inject.Inject

data class CurrentWeatherItem(
        val id: Int,
        val description: String,
        val temp: Double,
        val temp_min: Double,
        val temp_max: Double,
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

class CurrentWeatherMapper @Inject constructor(
        private val windMapper: WindMapper,
        private val sysMapper: SysMapper
) : ItemMapper<CurrentWeather, CurrentWeatherItem> {
    override fun mapToPresentation(model: CurrentWeather) = CurrentWeatherItem(
            id = model.id,
            description = model.description,
            temp = model.temp,
            temp_min = model.temp_min,
            temp_max = model.temp_max,
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
            temp_min = modelItem.temp_min,
            temp_max = modelItem.temp_max,
            pressure = modelItem.pressure,
            visibility = modelItem.visibility,
            clouds = modelItem.clouds,
            wind = windMapper.mapToDomain(modelItem.wind),
            sys = sysMapper.mapToDomain(modelItem.sys),
            dt = modelItem.dt
    )

}

class WindMapper @Inject constructor() : ItemMapper<Wind, WindItem> {
    override fun mapToPresentation(model: Wind) = WindItem(
            speed = model.speed,
            deg = model.deg
    )

    override fun mapToDomain(modelItem: WindItem) = Wind(
            speed = modelItem.speed,
            deg = modelItem.deg
    )
}

class SysMapper @Inject constructor() : ItemMapper<Sys, SysItem> {
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