package com.nuweather.feature.currentweather

import android.arch.lifecycle.MutableLiveData
import com.nuweather.R
import com.nuweather.base.BaseViewModel
import com.nuweather.data.remote.error.ApiException
import com.nuweather.domain.model.Weather
import com.nuweather.domain.usecase.GetCurrentWeatherCase
import com.nuweather.rx.SchedulerProvider
import com.nuweather.util.PartOfDay
import com.nuweather.util.getPartOfDay
import io.reactivex.rxkotlin.subscribeBy

class CurrentWeatherViewModel(
    private val useCase: GetCurrentWeatherCase,
    private val schedulerProvider: SchedulerProvider
) : BaseViewModel() {

    val currentWeather = MutableLiveData<Weather>()
    val weatherImage = MutableLiveData<Int>()
    val query = MutableLiveData<String>()

    fun getCurrentWeather() {
        query.value?.let { query ->
            if (query.isNotBlank() && query.isNotEmpty()) {
                enableLoading()
                compositeDisposable.add(useCase.createObservable(GetCurrentWeatherCase.Params(query))
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .subscribeBy(
                        onSuccess = {
                            disableLoading()
                            currentWeather.value = it
                            setWeatherImage(it.id)
                        },
                        onError = {
                            disableLoading()
                            if (it is ApiException) {
                                setError(it)
                            }
                        }
                    )
                )
            }
        }
    }

    private fun setWeatherImage(id: Long) {
        val partOfDay = getPartOfDay()
        val ic = when (id) {
            200L, 230L -> {
                if (partOfDay == PartOfDay.MORNING) R.drawable.ic_cloud_lightning_rain_sun
                else R.drawable.ic_cloud_rain_lightning_moon_night_storm
            }
            201L -> R.drawable.ic_cloud_lightening_rain
            211L -> R.drawable.ic_cloud_lightening
            212L -> R.drawable.ic_cloud_lightening_storm_thunder
            801L -> {
                if (partOfDay == PartOfDay.MORNING) R.drawable.ic_cloud_cloudy_sun
                else R.drawable.ic_cloud_moon
            }
            210L, 221L -> {
                if (partOfDay == PartOfDay.MORNING) R.drawable.ic_cloud_lightning_sun
                else R.drawable.ic_cloud_lightning_moon_night_storm
            }
            231L, 232L -> R.drawable.ic_cloud_lightening_rain
            in 520L..531L, 202L -> R.drawable.ic_cloud_rain
            in 300L..321L, in 501L..504 -> {
                if (partOfDay == PartOfDay.MORNING) R.drawable.ic_cloud_rain_sun
                else R.drawable.ic_cloud_moon_rain
            }
            in 600L..622L, 511L -> R.drawable.ic_snow_snowflake_winter
            in 700L..781L -> R.drawable.ic_wave
            in 802L..804L -> R.drawable.ic_cloud_cloudy
            else -> {
                if (partOfDay == PartOfDay.MORNING) R.drawable.ic_sun
                else R.drawable.ic_moon

            }
        }
        weatherImage.value = ic
    }
}