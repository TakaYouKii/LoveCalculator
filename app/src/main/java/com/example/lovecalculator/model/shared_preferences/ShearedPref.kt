package com.example.lovecalculator.model.shared_preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class ShearedPref @Inject constructor(private val shearedPref: SharedPreferences) {

    fun isOnBoardingShow(): Boolean{
        return shearedPref.getBoolean(SHOWED_KEY, false)
    }

    fun onOnBoardingShowed(){
        return shearedPref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    companion object{
        const val PREF_NAME = "pref.name"
        const val SHOWED_KEY = "seen.key"
    }
}