package com.nuweather.data

import com.nuweather.data.mapper.WeatherMapper
import com.nuweather.data.remote.api.WeatherApi
import com.nuweather.domain.model.Weather
import com.nuweather.domain.repository.WeatherRepository
import io.reactivex.Single

class WeatherRepositoryImpl constructor(
    private val weatherApi: WeatherApi,
    private val weatherMapper: WeatherMapper
) : WeatherRepository {

    override fun getCurrentWeather(query: String): Single<Weather> {
        return weatherApi.getCurrentWeather(query).map {
            weatherMapper.mapToDomain(it.mapToEntity())
        }
    }
}