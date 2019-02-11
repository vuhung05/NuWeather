package com.nuweather.domain.usecase

import com.nuweather.domain.model.CurrentWeather
import com.nuweather.domain.repository.WeatherRepository
import io.reactivex.Single

class GetCurrentWeatherCase constructor(
    private val currentWeatherRepository: WeatherRepository
) : UseCase<GetCurrentWeatherCase.Params, Single<CurrentWeather>>() {
    override fun createObservable(params: Params?): Single<CurrentWeather> {
        params?.let {
            return currentWeatherRepository.getCurrentWeather(it.query)
        }
        return Single.error(Throwable("The params is nullable"))
    }

    override fun onCleared() {

    }

    data class Params(val query: String)
}
