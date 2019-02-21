package com.nuweather.data.model

import com.nuweather.data.base.Entity

data class FiveDaysForecastEntity(
    val list: List<WeatherEntity>
) : Entity()