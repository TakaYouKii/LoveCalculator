package com.example.lovecalculator.presenter

import android.os.Build
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class MainFragmentPresenter @Inject constructor(private val api: LoveApi) {

    lateinit var mainView: MainView

    fun getLoveResult(firstName: String, secondName: String){
        api.calculateMatching(
            firstName,
            secondName,
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
    fun getDateTimeNow():String{
        val currentDateTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.now()
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val date = currentDateTime.format(dateFormatter)
        val time = currentDateTime.format(timeFormatter)
        return "Date: ${date}\nTime:${time}"
    }

    fun attachView(view: MainView){
        this.mainView = view
    }
}