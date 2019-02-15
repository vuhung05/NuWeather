package com.nuweather.feature.currentweather

import android.arch.lifecycle.MutableLiveData
import com.nuweather.base.BaseViewModel
import com.nuweather.domain.usecase.GetCurrentWeatherCase
import com.nuweather.model.CurrentWeatherItem
import com.nuweather.model.CurrentWeatherMapper
import com.nuweather.rx.SchedulerProvider
import io.reactivex.rxkotlin.subscribeBy

class CurrentWeatherViewModel constructor(
    private val useCase: GetCurrentWeatherCase,
    private val schedulerProvider: SchedulerProvider,
    private val currentWeatherMapper: CurrentWeatherMapper
) : BaseViewModel() {

    val currentWeatherItem = MutableLiveData<CurrentWeatherItem>()
    val query = MutableLiveData<String>()

    fun searchClick() {
        getCurrentWeather()
    }

    private fun getCurrentWeather() {
        query.value?.let { query ->
            if (query.isNotBlank()) {
                compositeDisposable.add(useCase.createObservable(GetCurrentWeatherCase.Params(query))
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .map { currentWeather -> currentWeatherMapper.mapToPresentation(currentWeather) }
                    .subscribeBy(
                        onSuccess = { currentWeatherItem.value = it },
                        onError = {}
                    )
                )
            }
        }
    }
}