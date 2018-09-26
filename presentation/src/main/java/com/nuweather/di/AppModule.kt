package com.nuweather.di

import android.app.Application
import android.content.Context
import com.nuweather.rx.AppSchedulerProvider
import com.nuweather.rx.SchedulerProvider
import org.koin.dsl.module.module

val appModule = module(override = true) {
    single { createContext(get()) }
    single { createSchedulerProvider() }
}

fun createContext(application: Application): Context {
    return application
}

fun createSchedulerProvider(): SchedulerProvider {
    return AppSchedulerProvider()
}
