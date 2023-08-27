package com.example.lovecalculator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.model.LoveModel

@Suppress("DEPRECATION")
class ResultFragment : Fragment() {


    lateinit var binding: FragmentResultBinding
    private lateinit var loveModel: LoveModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        loveModel = this.arguments?.getSerializable("love") as LoveModel
        binding.tvFirstName.text = loveModel.firstName
        binding.tvSecondName.text = loveModel.secondName
        binding.tvPercentage.text = loveModel.percentage + "%"
        binding.tvResult.text = loveModel.result
    }


}