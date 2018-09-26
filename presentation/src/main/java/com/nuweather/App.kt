package com.nuweather

import android.app.Application
import com.nuweather.data.di.networkModule
import com.nuweather.data.di.repositoryModule
import com.nuweather.di.appModule
import com.nuweather.di.viewModelModule
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
                appModule,
                networkModule,
                viewModelModule,
                repositoryModule
        ))
    }
}