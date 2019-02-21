package com.nuweather.data.remote.response

import com.google.gson.annotations.SerializedName
import com.nuweather.data.model.FiveDaysForecastEntity
import com.nuweather.data.remote.response.base.BaseResponse

data class FiveDaysForecastResponse(
    @SerializedName("cod") val cod: String,
    @SerializedName("message") val message: Double,
    @SerializedName("cnt") val cnt: Int,
    @SerializedName("list") val list: List<WeatherResponse>
) : BaseResponse() {

    override fun mapToEntity() = FiveDaysForecastEntity(list.map { it.mapToEntity() })
}