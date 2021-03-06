package com.nuweather.feature

import android.os.Bundle
import com.nuweather.R
import com.nuweather.base.BaseActivity
import com.nuweather.feature.currentweather.CurrentWeatherFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CurrentWeatherFragment.newInstance())
                .commitNow()

        }
    }
}
