package com.nuweather.feature.currentweather

import android.arch.lifecycle.Observer
import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.nuweather.BR
import com.nuweather.R
import com.nuweather.base.BaseFragment
import com.nuweather.databinding.FragmentCurrentWeatherBinding
import kotlinx.android.synthetic.main.fragment_current_weather.*
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
        viewModel.getFiveDaysForecast()
    }

    override fun onResume() {
        super.onResume()
        viewModel.setWeatherBackground()
    }

    override fun observe() {
        super.observe()
        viewModel.fiveDaysForecast.observe(this, Observer {
            val entries = ArrayList<Entry>()
            var xValue = 1F
            it?.list?.let { list ->
                for (index in 0..4) {
                    entries.add(Entry(xValue, list[index].temp.toFloat()))
                    xValue += 0.5F
                }
            }
            val dataSet = LineDataSet(entries, "")
            dataSet.color = Color.WHITE
            dataSet.valueTextColor = Color.WHITE
            dataSet.lineWidth = 4f
            dataSet.circleRadius = 8f
            dataSet.valueTextSize = 14f

            tempChart.setDrawGridBackground(false)
            tempChart.description.isEnabled = false
            tempChart.setDrawBorders(false)
            tempChart.axisLeft.isEnabled = false
            tempChart.axisRight.isEnabled = false
            tempChart.xAxis.isEnabled = false
            tempChart.axisRight.setDrawAxisLine(false)
            tempChart.axisRight.setDrawGridLines(false)
            tempChart.xAxis.setDrawAxisLine(false)
            tempChart.xAxis.setDrawGridLines(false)
            tempChart.legend.isEnabled = false
            tempChart.axisLeft.setDrawLabels(false)
            tempChart.axisRight.setDrawLabels(false)
            tempChart.xAxis.setDrawLabels(false)

            tempChart.data = LineData(dataSet)
            tempChart.invalidate()
        })
    }
}