package com.nuweather.data.di

import android.arch.persistence.room.Room
import android.content.Context
import com.nuweather.data.Constants
import com.nuweather.data.CurrentWeatherRepositoryImpl
import com.nuweather.data.local.db.AppDatabase
import com.nuweather.data.local.pref.AppPrefs
import com.nuweather.data.local.pref.PrefHelper
import com.nuweather.domain.repository.CurrentWeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @DatabaseInfo
    fun providerDatabaseName(): String {
        return Constants.DATABASE_NAME
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName).fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun providePrefHelper(appPrefs: AppPrefs): PrefHelper {
        return appPrefs
    }

    @Provides
    @Singleton
    fun providerAppPrefs(context: Context): AppPrefs {
        return AppPrefs(context)
    }

    @Provides
    @Singleton
    fun providerCurrentWeatherRepository(repository: CurrentWeatherRepositoryImpl): CurrentWeatherRepository {
        return repository
    }
}
