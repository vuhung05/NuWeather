package com.nuweather.util

import java.util.*

fun getPartOfDay(): PartOfDay {
    val calendar = Calendar.getInstance()
    return when (calendar.get(Calendar.HOUR_OF_DAY)) {
        in 4..12 -> PartOfDay.MORNING
        in 13..18 -> PartOfDay.AFTERNOON
        else -> PartOfDay.NIGHT
    }
}

enum class PartOfDay { MORNING, AFTERNOON, NIGHT }