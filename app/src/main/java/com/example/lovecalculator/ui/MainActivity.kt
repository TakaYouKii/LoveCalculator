package com.example.lovecalculator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.model.ShearedPref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    @Inject
//    lateinit var shearedPreferences: ShearedPref
    private val shearedPreferences:ShearedPref by lazy {
        ShearedPref(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(!shearedPreferences.isOnBoardingShow()){
            findNavController(R.id.mainFragment).navigate(R.id.navigation_on_boarding)
        }
    }

}