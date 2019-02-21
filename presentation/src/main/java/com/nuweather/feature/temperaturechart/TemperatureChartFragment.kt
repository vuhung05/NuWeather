package com.nuweather.feature.temperaturechart

import android.os.Bundle
import android.view.View
import com.nuweather.BR
import com.nuweather.R
import com.nuweather.base.BaseFragment
import com.nuweather.databinding.FragmentTemperatureChartBinding
import org.koin.android.ext.android.inject

class TemperatureChartFragment : BaseFragment<FragmentTemperatureChartBinding, TemperatureChartViewModel>() {
    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_temperature_chart

    override val viewModel: TemperatureChartViewModel by inject()

    companion object {
        fun newInstance() = TemperatureChartFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.query.value = "Ho Chi Minh City"
        viewModel.getFiveDaysForecastCase()
    }
}
