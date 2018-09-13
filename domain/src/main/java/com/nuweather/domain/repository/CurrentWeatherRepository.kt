package com.nuweather.domain.repository

import com.nuweather.domain.model.CurrentWeather
import io.reactivex.Single

interface CurrentWeatherRepository : Repository {
    fun getCurrentWeather(query: String): Single<CurrentWeather>
}