package com.nuweather.di

import com.nuweather.model.CurrentWeatherMapper
import com.nuweather.model.SysMapper
import com.nuweather.model.WindMapper
import org.koin.dsl.module.module

val itemMapperModule = module {
    single { CurrentWeatherMapper(get(), get()) }
    single { WindMapper() }
    single { SysMapper() }
}