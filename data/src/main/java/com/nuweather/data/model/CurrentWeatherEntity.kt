package com.nuweather.data.model

import com.nuweather.data.base.Entity
import com.nuweather.data.base.EntityMapper
import com.nuweather.domain.model.CurrentWeather
import com.nuweather.domain.model.Sys
import com.nuweather.domain.model.Wind

data class CurrentWeatherEntity(
        val id: Int,
        val description: String,
        val temp: Double,
        val temp_min: Double,
        val temp_max: Double,
        val pressure: Int,
        val visibility: Int,
        val clouds: Int,
        val wind: WindEntity,
        val sys: SysEntity,
        val dt: Int
) : Entity()

data class WindEntity(
        val speed: Double,
        val deg: Int
) : Entity()


data class SysEntity(
        val type: Int,
        val id: Int,
        val message: Double,
        val country: String,
        val sunrise: Int,
        val sunset: Int
) : Entity()

class CurrentWeatherMapper constructor(
        private val windMapper: WindMapper,
        private val sysMapper: SysMapper
) : EntityMapper<CurrentWeather, CurrentWeatherEntity> {
    override fun mapToDomain(entity: CurrentWeatherEntity) = CurrentWeather(
            id = entity.id,
            description = entity.description,
            temp = entity.temp,
            temp_min = entity.temp_min,
            temp_max = entity.temp_max,
            pressure = entity.pressure,
            visibility = entity.visibility,
            clouds = entity.clouds,
            wind = windMapper.mapToDomain(entity.wind),
            sys = sysMapper.mapToDomain(entity.sys),
            dt = entity.dt
    )

    override fun mapToEntity(model: CurrentWeather) = CurrentWeatherEntity(
            id = model.id,
            description = model.description,
            temp = model.temp,
            temp_min = model.temp_min,
            temp_max = model.temp_max,
            pressure = model.pressure,
            visibility = model.visibility,
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