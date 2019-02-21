package com.nuweather.data.di

import android.arch.persistence.room.Room
import android.content.Context
import com.nuweather.data.Constants
import com.nuweather.data.WeatherRepositoryImpl
import com.nuweather.data.local.db.AppDatabase
import com.nuweather.data.local.pref.AppPrefs
import com.nuweather.data.local.pref.PrefHelper
import com.nuweather.domain.repository.WeatherRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    single { createDatabaseName() }
    single { createAppDatabase(get(), get()) }
    single<PrefHelper> { AppPrefs(get()) }
    single<WeatherRepository> { WeatherRepositoryImpl(get(), get(), get()) }
}

fun createDatabaseName(): String {
    return Constants.DATABASE_NAME
}

fun createAppDatabase(dbName: String, context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
        .fallbackToDestructiveMigration()
        .build()
}
