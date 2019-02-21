package com.nuweather.data.mapper

import com.nuweather.data.base.EntityMapper
import com.nuweather.data.model.FiveDaysForecastEntity
import com.nuweather.domain.model.FiveDaysForecast

class FiveDaysForecastMapper(
    private val weatherMapper: WeatherMapper
) : EntityMapper<FiveDaysForecast, FiveDaysForecastEntity> {
    override fun mapToDomain(entity: FiveDaysForecastEntity) = FiveDaysForecast(
        list = entity.list.map { weatherMapper.mapToDomain(it) }
    )

    override fun mapToEntity(model: FiveDaysForecast) = FiveDaysForecastEntity(
        list = model.list.map { weatherMapper.mapToEntity(it) }
    )
}