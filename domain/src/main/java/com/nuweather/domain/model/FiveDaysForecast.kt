package com.nuweather.domain.model

data class FiveDaysForecast(
    val list: List<Weather>
) : Model()