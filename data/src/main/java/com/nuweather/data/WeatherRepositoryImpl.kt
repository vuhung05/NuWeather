package com.nuweather.data

import com.nuweather.data.model.CurrentWeatherMapper
import com.nuweather.data.remote.api.WeatherApi
import com.nuweather.domain.model.CurrentWeather
import com.nuweather.domain.repository.WeatherRepository
import io.reactivex.Single

class WeatherRepositoryImpl constructor(
    private val weatherApi: WeatherApi,
    private val currentWeatherMapper: CurrentWeatherMapper
) : WeatherRepository {

    override fun getCurrentWeather(query: String): Single<CurrentWeather> {
        return weatherApi.getCurrentWeather(query).map {
            currentWeatherMapper.mapToDomain(it.mapToEntity())
        }
    }
}