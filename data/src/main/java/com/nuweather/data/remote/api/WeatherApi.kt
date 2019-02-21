package com.nuweather.data.remote.api

import com.nuweather.data.BuildConfig.API_KEY
import com.nuweather.data.remote.response.FiveDaysForecastResponse
import com.nuweather.data.remote.response.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    fun getCurrentWeather(@Query("q") query: String,
                          @Query("appid") key: String = API_KEY): Single<WeatherResponse>

    @GET("forecast")
    fun getFiveDaysForecast(@Query("q") query: String,
                            @Query("appid") key: String = API_KEY): Single<FiveDaysForecastResponse>
}