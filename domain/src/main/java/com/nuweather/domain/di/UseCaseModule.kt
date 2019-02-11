package com.nuweather.domain.di

import com.nuweather.domain.usecase.GetCurrentWeatherCase
import org.koin.dsl.module.module

val useCaseModule = module {
    single { GetCurrentWeatherCase(get()) }
}