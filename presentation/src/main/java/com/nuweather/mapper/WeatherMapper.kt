package com.nuweather.mapper

import com.nuweather.base.ItemMapper
import com.nuweather.domain.model.Weather
import com.nuweather.model.WeatherItem

class WeatherMapper constructor(
    private val windMapper: WindMapper,
    private val sysMapper: SysMapper
) : ItemMapper<Weather, WeatherItem> {
    override fun mapToPresentation(model: Weather) = WeatherItem(
        id = model.id,
        city = model.city,
        description = model.description,
        temp = model.temp,
        tempMin = model.tempMin,
        tempMax = model.tempMax,
        pressure = model.pressure,
        visibility = model.visibility,
        humidity = model.humidity,
        clouds = model.clouds,
        wind = windMapper.mapToPresentation(model.wind),
        sys = sysMapper.mapToPresentation(model.sys),
        dt = model.dt
    )

    override fun mapToDomain(modelItem: WeatherItem) = Weather(
        id = modelItem.id,
        city = modelItem.city,
        description = modelItem.description,
        temp = modelItem.temp,
        tempMin = modelItem.tempMin,
        tempMax = modelItem.tempMax,
        pressure = modelItem.pressure,
        visibility = modelItem.visibility,
        humidity = modelItem.humidity,
        clouds = modelItem.clouds,
        wind = windMapper.mapToDomain(modelItem.wind),
        sys = sysMapper.mapToDomain(modelItem.sys),
        dt = modelItem.dt
    )

}