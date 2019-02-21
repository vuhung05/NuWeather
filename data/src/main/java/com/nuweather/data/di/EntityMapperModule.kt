package com.nuweather.data.di

import com.nuweather.data.mapper.FiveDaysForecastMapper
import com.nuweather.data.mapper.SysMapper
import com.nuweather.data.mapper.WeatherMapper
import com.nuweather.data.mapper.WindMapper
import org.koin.dsl.module.module

val entityModuleMapper = module {
    single { WeatherMapper(get(), get()) }
    single { WindMapper() }
    single { SysMapper() }
    single { FiveDaysForecastMapper(get()) }
}