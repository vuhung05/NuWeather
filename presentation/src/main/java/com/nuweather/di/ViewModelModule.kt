package com.nuweather.di

import com.nuweather.domain.usecase.GetCurrentWeatherCase
import com.nuweather.model.CurrentWeatherMapper
import com.nuweather.model.SysMapper
import com.nuweather.model.WindMapper
import com.nuweather.ui.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get(), get()) }
    factory { GetCurrentWeatherCase(get()) }
    factory { CurrentWeatherMapper(get(), get()) }
    factory { WindMapper() }
    factory { SysMapper() }
}