package com.example.lovecalculator.view

interface ResultView {
    fun showResult(
        firstName: String,
        secondName: String,
        percentage: String,
        result: String,
        )
}