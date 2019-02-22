package com.nuweather.feature.currentweather

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nuweather.R
import com.nuweather.base.BaseRecyclerAdapter
import com.nuweather.databinding.ItemWeatherBinding
import com.nuweather.domain.model.Weather

class CurrentWeatherAdapter : BaseRecyclerAdapter<Weather>(DIFF_CALLBACK) {

    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding {
        return DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_weather, parent, false)
    }

    override fun bind(binding: ViewDataBinding, item: Weather) {
        if (binding is ItemWeatherBinding) {
            binding.weather = item
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Weather>() {
            override fun areItemsTheSame(oldItem: Weather?, newItem: Weather?): Boolean {
                return oldItem?.id == newItem?.id
            }

            override fun areContentsTheSame(oldItem: Weather?, newItem: Weather?): Boolean {
                return oldItem == newItem
            }
        }
    }
}