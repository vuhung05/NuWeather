package com.nuweather

import com.nuweather.di.component.DaggerAppComponent
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .build()
}