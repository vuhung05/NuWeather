package com.nuweather.di

import com.nuweather.feature.currentweather.CurrentWeatherViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { CurrentWeatherViewModel(get(), get(), get()) }
}