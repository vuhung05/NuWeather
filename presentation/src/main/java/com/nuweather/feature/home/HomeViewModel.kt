package com.nuweather.feature.home

import android.arch.lifecycle.MutableLiveData
import com.nuweather.R
import com.nuweather.base.BaseViewModel
import com.nuweather.util.PartOfDay
import com.nuweather.util.getPartOfDay

class HomeViewModel : BaseViewModel() {

    val weatherBackground = MutableLiveData<Int>()

    fun setWeatherBackground() {
        val background = when (getPartOfDay()) {
            PartOfDay.MORNING -> R.drawable.bg_morning
            PartOfDay.AFTERNOON -> R.drawable.bg_afternoon
            else -> R.drawable.bg_night
        }
        weatherBackground.value = background
    }
}