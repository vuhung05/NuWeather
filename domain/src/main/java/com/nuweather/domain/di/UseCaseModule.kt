package com.nuweather.domain.di

import com.nuweather.domain.usecase.GetCurrentWeatherCase
import com.nuweather.domain.usecase.GetFiveDaysForecastCase
import org.koin.dsl.module.module

val useCaseModule = module {
    single { GetCurrentWeatherCase(get()) }
    single { GetFiveDaysForecastCase(get()) }
}