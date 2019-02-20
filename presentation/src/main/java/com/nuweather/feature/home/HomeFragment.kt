package com.nuweather.feature.home

import android.os.Bundle
import android.view.View
import com.nuweather.BR
import com.nuweather.R
import com.nuweather.base.BaseFragment
import org.koin.android.ext.android.inject
import com.nuweather.databinding.FragmentHomeBinding
import com.nuweather.feature.currentweather.CurrentWeatherFragment
import com.nuweather.feature.temperaturechart.TemperatureChartFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_home

    override val viewModel: HomeViewModel by inject()

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) {
            fragmentManager?.beginTransaction()?.replace(R.id.currentWeather,
                CurrentWeatherFragment.newInstance())?.commit()
            fragmentManager?.beginTransaction()?.replace(R.id.temperatureChart,
                TemperatureChartFragment.newInstance())?.commit()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.setWeatherBackground()
    }
}