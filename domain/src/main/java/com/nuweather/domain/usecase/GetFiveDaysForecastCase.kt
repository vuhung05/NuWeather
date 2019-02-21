package com.nuweather.domain.usecase

import com.nuweather.domain.model.FiveDaysForecast
import com.nuweather.domain.repository.WeatherRepository
import io.reactivex.Single

class GetFiveDaysForecastCase constructor(
    private val currentWeatherRepository: WeatherRepository
) : UseCase<GetFiveDaysForecastCase.Params, Single<FiveDaysForecast>>() {
    override fun createObservable(params: Params?): Single<FiveDaysForecast> {
        params?.let {
            return currentWeatherRepository.getFiveDaysForecast(it.query)
        }
        return Single.error(Throwable("The params is nullable"))
    }

    override fun onCleared() {

    }

    data class Params(val query: String)
}
