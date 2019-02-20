package com.nuweather.data.mapper

import com.nuweather.data.base.EntityMapper
import com.nuweather.data.model.WeatherEntity
import com.nuweather.domain.model.Weather

class WeatherMapper constructor(
    private val windMapper: WindMapper,
    private val sysMapper: SysMapper
) : EntityMapper<Weather, WeatherEntity> {
    override fun mapToDomain(entity: WeatherEntity) = Weather(
        id = entity.id,
        city = entity.city,
        description = entity.description,
        temp = entity.temp,
        tempMin = entity.temp_min,
        tempMax = entity.temp_max,
        pressure = entity.pressure,
        visibility = entity.visibility,
        humidity = entity.humidity,
        clouds = entity.clouds,
        wind = windMapper.mapToDomain(entity.wind),
        sys = sysMapper.mapToDomain(entity.sys),
        dt = entity.dt
    )

    override fun mapToEntity(model: Weather) = WeatherEntity(
        id = model.id,
        city = model.city,
        description = model.description,
        temp = model.temp,
        temp_min = model.tempMin,
        temp_max = model.tempMax,
        pressure = model.pressure,
        visibility = model.visibility,
        humidity = model.humidity,
        clouds = model.clouds,
        wind = windMapper.mapToEntity(model.wind),
        sys = sysMapper.mapToEntity(model.sys),
        dt = model.dt
    )

}