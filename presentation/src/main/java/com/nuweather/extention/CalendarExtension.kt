package com.nuweather.extention

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.getTimeString(): String {
    val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
    return formatter.format(this.time)
}