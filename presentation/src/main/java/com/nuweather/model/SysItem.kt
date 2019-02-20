package com.nuweather.model

import com.nuweather.base.ModelItem

data class SysItem(
    val type: Int,
    val id: Long,
    val message: Double,
    val country: String,
    val sunrise: Long,
    val sunset: Long
) : ModelItem()
