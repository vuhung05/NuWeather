package com.nuweather.data.local.pref

import android.content.Context
import android.content.SharedPreferences

class AppPrefs constructor(
        context: Context
) : PrefHelper {
    var sharedPreferences: SharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    companion object {
        private const val FIRST_RUN = "first_run";
    }

    override fun isFirstRun(): Boolean {
        val first = sharedPreferences.getBoolean(FIRST_RUN, true)
        if (first) {
            sharedPreferences.edit().putBoolean(FIRST_RUN, false).apply()
        }

        return first
    }

}