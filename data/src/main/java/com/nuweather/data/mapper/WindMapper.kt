package com.nuweather.data.mapper

import com.nuweather.data.base.EntityMapper
import com.nuweather.data.model.WindEntity
import com.nuweather.domain.model.Wind

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