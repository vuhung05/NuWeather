package com.nuweather.ui

import android.arch.lifecycle.MutableLiveData
import android.database.Observable
import android.databinding.ObservableField
import android.util.Log
import com.nuweather.base.BaseViewModel
import com.nuweather.domain.usecase.GetCurrentWeatherCase
import com.nuweather.model.CurrentWeatherItem
import com.nuweather.model.CurrentWeatherMapper
import com.nuweather.rx.SchedulerProvider
import javax.inject.Inject

class MainViewModel @Inject constructor(
        val useCase: GetCurrentWeatherCase,
        val schedulerProvider: SchedulerProvider,
        val currentWeatherMapper: CurrentWeatherMapper
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
                        .observeOn(schedulerProvider.io())
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