package com.example.lovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface LoveApi {

    @GET("getPercentage")
    fun calculateMatching(
        @Query("fname") firstName:String,
        @Query("sname") secondName:String,
        @Header("X-RapidAPI-Key") key: String = "ce39dcf001msh31f1e21f23fb445p1d755fjsn19e38417b35b",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
    ): Call<LoveModel>
}