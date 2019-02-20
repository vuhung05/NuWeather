package com.nuweather.di

import com.nuweather.mapper.SysMapper
import com.nuweather.mapper.WeatherMapper
import com.nuweather.mapper.WindMapper
import org.koin.dsl.module.module

val itemMapperModule = module {
    single { WeatherMapper(get(), get()) }
    single { WindMapper() }
    single { SysMapper() }
}