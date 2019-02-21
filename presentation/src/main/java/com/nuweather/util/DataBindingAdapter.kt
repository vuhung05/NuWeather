package com.nuweather.util

import android.databinding.BindingAdapter
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.AppCompatImageView

@BindingAdapter("imageResource")
fun setImageResource(imageView: AppCompatImageView, resource: Int) {
    imageView.setImageResource(resource)
}

@BindingAdapter("setOnRefreshListener")
fun setOnRefreshListener(refreshLayout: SwipeRefreshLayout, listener: () -> Unit) {
    refreshLayout.setOnRefreshListener {
        listener.invoke()
        refreshLayout.isRefreshing = false
    }
}