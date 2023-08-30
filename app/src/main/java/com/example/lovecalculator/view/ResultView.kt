package com.example.lovecalculator.view

import com.example.lovecalculator.model.LoveModel

interface ResultView {


    fun showResult(
        firstName: String,
        secondName: String,
        percentage: String,
        result: String,
        )

    fun navigateToHistoryFragment()
    fun navigateToMainFragment()
}