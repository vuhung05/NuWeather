package com.nuweather.domain.usecase

import com.nuweather.domain.model.CurrentWeather
import com.nuweather.domain.repository.CurrentWeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class GetCurrentWeatherCase @Inject constructor(
        private val currentWeatherRepository: CurrentWeatherRepository
) : UseCase<GetCurrentWeatherCase.Params, Single<CurrentWeather>>() {
    override fun createObservable(params: Params?): Single<CurrentWeather> {
        params?.let { currentWeatherRepository.getCurrentWeather(it.query) }
        return Single.error(Throwable(""))
    }

    override fun onCleared() {

    }

    data class Params(val query: String)
}
