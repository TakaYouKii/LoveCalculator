package com.example.lovecalculator.ui.history

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.view.HistoryView

class HistoryFragment : Fragment(), HistoryView{
    private lateinit var binding: FragmentHistoryBinding
    private val adapter = HistoryAdapter(this::onLongClick, this::onClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            loveRecyclerView.adapter = adapter
            btnGoToMain.setOnClickListener{
                navigateToMainFragment()
            }
        }

        val data = App.appDatabase.loveDao().getAll()
        adapter.addLoveItem(data)

    }

    private fun onLongClick(i: Int): Boolean {
        val list = App.appDatabase.loveDao().getAll()
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle(getString(R.string.delete))
        builder.setMessage(getString(R.string.delete_message) )
        builder.setNeutralButton(getString(R.string.cansel)) { _, _ ->
        }
        builder.setPositiveButton(getString(R.string.yes)) { _, _ ->
            val loveListItem = list[i]
            App.appDatabase.loveDao().delete(loveListItem)
            findNavController().navigate(R.id.historyFragment)
        }
        builder.show()
        return true
    }

    private fun onClick(i: Int) {
        val list = App.appDatabase.loveDao().getAll()
        val listOfDateTime = App.appDatabase.loveDatetimeDao().getAll()
        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Date-Time")
        builder.setMessage(listOfDateTime[i].dateTime)

        builder.setPositiveButton(getString(R.string.ok)) { _, _ ->
            findNavController().navigate(R.id.historyFragment)
        }
        builder.show()
    }

    override fun navigateToMainFragment() {
        findNavController().navigate(R.id.mainFragment)
    }

}