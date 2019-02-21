package com.nuweather.data.remote.response.base

import com.nuweather.data.base.Entity

abstract class BaseResponse {
    abstract fun mapToEntity(): Entity
}