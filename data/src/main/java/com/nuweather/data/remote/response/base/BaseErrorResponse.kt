package com.nuweather.data.remote.response.base

import com.google.gson.annotations.SerializedName

class BaseErrorResponse(
    @SerializedName("cod") val code: String,
    @SerializedName("message") val message: String?
)
