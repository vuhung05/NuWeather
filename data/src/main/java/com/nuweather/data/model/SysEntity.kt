package com.nuweather.data.model

import com.nuweather.data.base.Entity

data class SysEntity(
    val type: Int?,
    val id: Long?,
    val message: Double?,
    val country: String?,
    val sunrise: Long?,
    val sunset: Long?
) : Entity()
