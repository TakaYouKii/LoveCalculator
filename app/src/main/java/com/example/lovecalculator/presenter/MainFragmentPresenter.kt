package com.example.lovecalculator.presenter

import android.util.Log
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import com.example.lovecalculator.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragmentPresenter(val mainView: MainView) {

    var api =  RetrofitService().api
    fun getLoveResult(firstName: String, secondName: String){
        api.calculateMatching(
            firstName,
            secondName
        ).enqueue(object : Callback<LoveModel> {

            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let {model ->
                    mainView.navigateToResultFragment(response.body()!!)
                }
            }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                mainView.showError(t.message.toString())
            }

        })
    }
}