package com.nuweather

import android.app.Application
import com.nuweather.data.di.entityModuleMapper
import com.nuweather.data.di.networkModule
import com.nuweather.data.di.repositoryModule
import com.nuweather.di.appModule
import com.nuweather.di.viewModelModule
import com.nuweather.di.itemMapperModule
import com.nuweather.domain.di.useCaseModule
import org.koin.android.ext.android.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
            appModule,
            networkModule,
            useCaseModule,
            viewModelModule,
            repositoryModule,
            itemMapperModule,
            entityModuleMapper
        ))
    }
}