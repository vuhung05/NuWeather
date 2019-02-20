package com.nuweather.mapper

import com.nuweather.base.ItemMapper
import com.nuweather.domain.model.Sys
import com.nuweather.model.SysItem

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