package com.nuweather.di.builder

import android.app.Application
import android.content.Context
import com.nuweather.data.di.NetworkModule
import com.nuweather.data.di.RepositoryModule
import com.nuweather.rx.AppSchedulerProvider
import com.nuweather.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, NetworkModule::class, RepositoryModule::class])
class AppModule {
    @Singleton
    @Provides
    fun providerContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun providerSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}