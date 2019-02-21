package com.nuweather.feature.currentweather

import android.os.Bundle
import android.view.View
import com.nuweather.BR
import com.nuweather.R
import com.nuweather.base.BaseFragment
import com.nuweather.databinding.FragmentCurrentWeatherBinding
import org.koin.android.ext.android.inject

class CurrentWeatherFragment : BaseFragment<FragmentCurrentWeatherBinding, CurrentWeatherViewModel>() {
    companion object {
        fun newInstance() = CurrentWeatherFragment()
    }

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_current_weather

    override val viewModel: CurrentWeatherViewModel by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.query.value = "Ho Chi Minh City"
        viewModel.getCurrentWeather()
    }

    override fun onResume() {
        super.onResume()
        viewModel.setWeatherBackground()
    }
}