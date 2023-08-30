package com.example.lovecalculator.view

import com.example.lovecalculator.model.LoveModel

interface MainView {
    fun navigateToResultFragment(loveModel: LoveModel)
    fun navigateToHistoryFragment()

    fun showError(error: String)
}