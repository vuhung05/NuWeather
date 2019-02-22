package com.nuweather.extention

import android.support.design.widget.Snackbar
import android.widget.TextView
import com.nuweather.R

/**
 * Currently, there are no beautiful way for change SnakeBar message color
 * We can update it when upgrade android.support.design in future
 */
fun Snackbar.setTextColor(color: Int): Snackbar {
    val tv = view.findViewById(R.id.snackbar_text) as TextView
    tv.setTextColor(color)
    return this
}

fun Snackbar.setBackgroundColor(color: Int): Snackbar {
    view.setBackgroundColor(color)
    return this
}