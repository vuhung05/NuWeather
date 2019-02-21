package com.nuweather.data.remote.response.model

import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("type") val type: Int?,
    @SerializedName("id") val id: Long?,
    @SerializedName("message") val message: Double?,
    @SerializedName("country") val country: String?,
    @SerializedName("pod") val pod: String?,
    @SerializedName("sunrise") val sunrise: Long?,
    @SerializedName("sunset") val sunset: Long?
)