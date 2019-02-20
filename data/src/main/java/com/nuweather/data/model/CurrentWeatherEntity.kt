package com.nuweather.data.model

import com.nuweather.data.base.Entity
import com.nuweather.data.base.EntityMapper
import com.nuweather.domain.model.CurrentWeather
import com.nuweather.domain.model.Sys
import com.nuweather.domain.model.Wind

data class CurrentWeatherEntity(
    val id: Long,
    val city: String,
    val description: String,
    val temp: Int,
    val temp_min: Int,
    val temp_max: Int,
    val pressure: Double,
    val visibility: Double,
    val humidity: Double,
    val clouds: Double,
    val wind: WindEntity,
    val sys: SysEntity,
    val dt: Long
) : Entity()

data class WindEntity(
    val speed: Double,
    val deg: Double
) : Entity()


data class SysEntity(
    val type: Int,
    val id: Long,
    val message: Double,
    val country: String,
    val sunrise: Long,
    val sunset: Long
) : Entity()

class CurrentWeatherMapper constructor(
    private val windMapper: WindMapper,
    private val sysMapper: SysMapper
) : EntityMapper<CurrentWeather, CurrentWeatherEntity> {
    override fun mapToDomain(entity: CurrentWeatherEntity) = CurrentWeather(
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

    override fun mapToEntity(model: CurrentWeather) = CurrentWeatherEntity(
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

class WindMapper : EntityMapper<Wind, WindEntity> {
    override fun mapToDomain(entity: WindEntity) = Wind(
        speed = entity.speed,
        deg = entity.deg
    )

    override fun mapToEntity(model: Wind) = WindEntity(
        speed = model.speed,
        deg = model.deg
    )
}

class SysMapper : EntityMapper<Sys, SysEntity> {
    override fun mapToDomain(entity: SysEntity) = Sys(
        type = entity.type,
        id = entity.id,
        message = entity.message,
        country = entity.country,
        sunrise = entity.sunrise,
        sunset = entity.sunset
    )

    override fun mapToEntity(model: Sys) = SysEntity(
        type = model.type,
        id = model.id,
        message = model.message,
        country = model.country,
        sunrise = model.sunrise,
        sunset = model.sunset
    )
}