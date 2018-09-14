package com.nuweather.ui

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.nuweather.base.BaseViewModel
import com.nuweather.domain.usecase.GetCurrentWeatherCase
import com.nuweather.model.CurrentWeatherItem
import com.nuweather.model.CurrentWeatherMapper
import com.nuweather.rx.SchedulerProvider
import javax.inject.Inject

class MainViewModel @Inject constructor(
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
        query.value?.let {
            if (it.isNotBlank()) {
                compositeDisposable.add(useCase.createObservable(GetCurrentWeatherCase.Params(it))
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui())
                        .map { currentWeatherMapper.mapToPresentation(it) }
                        .subscribe({
                            currentWeatherItem.value = it
                        }, {

                        })
                )
            }
        }
    }
}