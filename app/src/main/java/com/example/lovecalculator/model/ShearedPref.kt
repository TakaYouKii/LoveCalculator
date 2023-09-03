package com.example.lovecalculator.model

import android.content.Context

class ShearedPref(private val context: Context) {
    private val shearedPreferences = context.getSharedPreferences(ShearedPref.PREF_NAME, Context.MODE_PRIVATE)

    fun isOnBoardingShow(): Boolean{
        return shearedPreferences.getBoolean(SHOWED_KEY, false)
    }

    fun onOnBoardingShowed(){
        return shearedPreferences.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    companion object{
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "seen.key"
    }
}