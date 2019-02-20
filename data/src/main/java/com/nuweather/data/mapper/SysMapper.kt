package com.nuweather.data.mapper

import com.nuweather.data.base.EntityMapper
import com.nuweather.data.model.SysEntity
import com.nuweather.domain.model.Sys

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