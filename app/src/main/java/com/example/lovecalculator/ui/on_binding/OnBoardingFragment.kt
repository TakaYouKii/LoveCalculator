package com.example.lovecalculator.ui.on_binding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentOnBoardingBinding
import com.example.lovecalculator.model.shared_preferences.ShearedPref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private  lateinit var binding: FragmentOnBoardingBinding
    private val adapter = OnBoardingAdapter(this::onClick)

    @Inject
    lateinit var shearedPreferences: ShearedPref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vpOnBinding.adapter = adapter

    }

    private fun onClick(){
        shearedPreferences.onOnBoardingShowed()
        findNavController().navigateUp()
    }
}