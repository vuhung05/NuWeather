package com.nuweather.di

import com.nuweather.feature.currentweather.CurrentWeatherViewModel
import com.nuweather.feature.home.HomeViewModel
import com.nuweather.feature.temperaturechart.TemperatureChartFragment
import com.nuweather.feature.temperaturechart.TemperatureChartViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { CurrentWeatherViewModel(get(), get(), get()) }
    viewModel { TemperatureChartViewModel() }
}