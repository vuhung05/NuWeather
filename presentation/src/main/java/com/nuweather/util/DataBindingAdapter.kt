package com.nuweather.util

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView

@BindingAdapter("imageResource")
fun setImageResource(imageView: AppCompatImageView, resource: Int) {
    imageView.setImageResource(resource)
}