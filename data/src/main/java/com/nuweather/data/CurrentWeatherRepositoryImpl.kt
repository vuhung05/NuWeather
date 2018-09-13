package com.nuweather.data

import com.nuweather.data.model.CurrentWeatherMapper
import com.nuweather.data.remote.api.WeatherApi
import com.nuweather.domain.model.CurrentWeather
import com.nuweather.domain.repository.CurrentWeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(
        private val weatherApi: WeatherApi,
        private val currentWeatherMapper: CurrentWeatherMapper
) : CurrentWeatherRepository {

    override fun getCurrentWeather(query: String): Single<CurrentWeather> {
        return weatherApi.getCurrentWeather(query).map {
            currentWeatherMapper.mapToDomain(it.mapToEntity())
        }
    }
}