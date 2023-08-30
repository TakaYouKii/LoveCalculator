package com.example.lovecalculator.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.presenter.MainFragmentPresenter
import com.example.lovecalculator.presenter.ResultFragmentPresenter
import com.example.lovecalculator.ui.history.HistoryFragment
import com.example.lovecalculator.view.ResultView

@Suppress("DEPRECATION")
class ResultFragment : Fragment(), ResultView {


    lateinit var binding: FragmentResultBinding
    private lateinit var loveModel: LoveModel
    private lateinit var presenter: ResultFragmentPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = ResultFragmentPresenter(this)
        binding = FragmentResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getResult()
        binding.btnGoToHistory.setOnClickListener{
            navigateToHistoryFragment()
        }
        binding.btnGoToMain.setOnClickListener{
            navigateToMainFragment()
        }
    }

    fun getResult(){
        loveModel = this.arguments?.getSerializable("love") as LoveModel

        presenter.getData(loveModel)
    }


    override fun showResult(
        firstName: String,
        secondName: String,
        percentage: String,
        result: String
    ) {
        with(binding){
            tvFirstName.text = firstName
            tvSecondName.text= secondName
            tvPercentage.text = "$percentage%"
            tvResult.text = result
        }
    }

    override fun navigateToHistoryFragment() {
        findNavController().navigate(R.id.historyFragment)
    }

    override fun navigateToMainFragment() {
        findNavController().navigate(R.id.mainFragment)
    }
}