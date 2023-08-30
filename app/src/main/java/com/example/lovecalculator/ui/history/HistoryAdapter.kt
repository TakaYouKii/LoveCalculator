package com.example.lovecalculator.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.databinding.LoveHistoryBinding
import com.example.lovecalculator.model.LoveModel

class HistoryAdapter(val onLongClick:(position: Int)->Boolean, val onClick:(position:Int)-> Unit): RecyclerView.Adapter<HistoryAdapter.LoveViewHolder>() {

    private val list = arrayListOf<LoveModel>()

    fun addLoveItem(loveList: List<LoveModel>){
        list.clear()
        list.addAll(loveList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoveViewHolder {
        return LoveViewHolder(LoveHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HistoryAdapter.LoveViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class LoveViewHolder(private val binding: LoveHistoryBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(loveModel: LoveModel){
            binding.tvFirstName.text = loveModel.firstName
            binding.tvSecondName.text = loveModel.secondName
            binding.tvPercentage.text = loveModel.percentage
            itemView.setOnLongClickListener{
                onLongClick(adapterPosition)
            }
            itemView.setOnClickListener{
                onClick(adapterPosition)
            }
        }
    }
}