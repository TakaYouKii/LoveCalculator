package com.example.lovecalculator.presenter

import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.ResultView

class ResultFragmentPresenter(private val resultView: ResultView) {
    fun getData(loveModel: LoveModel){
        resultView.showResult(
            loveModel.firstName,
            loveModel.secondName,
            loveModel.percentage,
            loveModel.result
        )
    }
}