package com.nuweather.mapper

import com.nuweather.base.ItemMapper
import com.nuweather.domain.model.Wind
import com.nuweather.model.WindItem

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