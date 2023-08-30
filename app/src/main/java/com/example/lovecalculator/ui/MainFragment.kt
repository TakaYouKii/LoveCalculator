package com.example.lovecalculator.ui

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentMainBinding
import com.example.lovecalculator.model.LoveDateTimeModel
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import com.example.lovecalculator.presenter.MainFragmentPresenter
import com.example.lovecalculator.ui.history.HistoryFragment
import com.example.lovecalculator.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainFragment : Fragment(), MainView{

    lateinit var binding: FragmentMainBinding
    private lateinit var presenter: MainFragmentPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter = MainFragmentPresenter(this)
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        binding.btnGoToHistory.setOnClickListener {
            navigateToHistoryFragment()
        }
    }

    private fun initClicker() {
        with(binding){
            calculateBtn.setOnClickListener{
                presenter.getLoveResult(firstEd.text.toString(), secondEd.text.toString() )
            }
        }
    }
    override fun navigateToResultFragment(loveModel: LoveModel) {
        App.appDatabase.loveDao().insert(loveModel)
        val allLove = App.appDatabase.loveDao().getAll()
        findNavController().navigate(R.id.resultFragment, bundleOf("love" to loveModel))
        var dateTime = LoveDateTimeModel(loveModelId = "${allLove.first().id}", dateTime = presenter.getDateTimeNow())
        App.appDatabase.loveDatetimeDao().insert(dateTime)
    }

    override fun navigateToHistoryFragment() {
        findNavController().navigate(R.id.historyFragment)
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }


}