package com.nuweather.data.di

import com.nuweather.data.model.CurrentWeatherMapper
import com.nuweather.data.model.SysMapper
import com.nuweather.data.model.WindMapper
import org.koin.dsl.module.module

val entityModuleMapper = module {
    single { CurrentWeatherMapper(get(), get()) }
    single { WindMapper() }
    single { SysMapper() }
}