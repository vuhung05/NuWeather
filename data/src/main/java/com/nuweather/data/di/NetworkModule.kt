package com.nuweather.data.di

import com.nuweather.data.BuildConfig.BASE_URL
import com.nuweather.data.remote.api.WeatherApi
import com.nuweather.data.remote.middleware.RxErrorHandlingCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val networkModule = module {
    single { createHttpClient() }
    single { createRetrofit(get()) }
    single { createUsersApi(get()) }
}

fun createHttpClient(): OkHttpClient {
    val loggingInterceptor = HttpLoggingInterceptor()
    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    val clientBuilder = OkHttpClient.Builder()
    clientBuilder.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
    clientBuilder.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
    clientBuilder.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
    clientBuilder.addInterceptor(loggingInterceptor)
    return clientBuilder.build()
}

fun createRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()

fun createUsersApi(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)

private const val CONNECT_TIMEOUT = 10L
private const val READ_TIMEOUT = 10L
private const val WRITE_TIMEOUT = 10L
