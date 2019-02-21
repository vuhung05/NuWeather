package com.nuweather.feature.temperaturechart

import android.arch.lifecycle.MutableLiveData
import com.nuweather.base.BaseViewModel
import com.nuweather.data.remote.error.ApiException
import com.nuweather.domain.model.FiveDaysForecast
import com.nuweather.domain.usecase.GetFiveDaysForecastCase
import com.nuweather.rx.SchedulerProvider
import io.reactivex.rxkotlin.subscribeBy

class TemperatureChartViewModel(
    private val useCase: GetFiveDaysForecastCase,
    private val schedulerProvider: SchedulerProvider
) : BaseViewModel() {

    val fiveDaysForecast = MutableLiveData<FiveDaysForecast>()
    val query = MutableLiveData<String>()

    fun getFiveDaysForecastCase() {
        query.value?.let { query ->
            if (query.isNotBlank() && query.isNotEmpty()) {
                enableLoading()
                compositeDisposable.add(useCase.createObservable(GetFiveDaysForecastCase.Params(query))
                    .subscribeOn(schedulerProvider.io())
                    .observeOn(schedulerProvider.ui())
                    .subscribeBy(
                        onSuccess = {
                            disableLoading()
                            fiveDaysForecast.value = it
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
}