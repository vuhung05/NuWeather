package com.nuweather.feature.temperaturechart

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

}
