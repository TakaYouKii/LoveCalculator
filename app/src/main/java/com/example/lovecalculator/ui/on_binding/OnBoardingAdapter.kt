package com.example.lovecalculator.ui.on_binding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lovecalculator.databinding.OnBoardingItemsBinding
import com.example.lovecalculator.model.OnBoarding

class OnBoardingAdapter(private val onClick:()-> Unit): RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){

    private val data = arrayListOf<OnBoarding>(
        OnBoarding("Вкусная еда","У нас в заведении - вкусная еда, приготовленная с любовью и заботой.", "https://static.vecteezy.com/system/resources/thumbnails/019/607/567/small/fast-food-vector-clipart-design-graphic-clipart-design-free-png.png"),
        OnBoarding("Бесплатная доставка", "Мы рады предложить нашим клиентам услугу бесплатной доставки.", "https://cdni.iconscout.com/illustration/premium/thumb/food-delivery-in-coronavirus-pandemic-5071253-4257131.png"),
        OnBoarding("Удобная оплата", "У нас предоставлена легкая и удобная система оплаты для вашего удобства.", "https://creazilla-store.fra1.digitaloceanspaces.com/cliparts/3229460/easy-payment-clipart-md.png")
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(OnBoardingItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class OnBoardingViewHolder(private val binding: OnBoardingItemsBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(onBoarding: OnBoarding){

            Glide.with(binding.ivBoard).load(onBoarding.image).into(binding.ivBoard)
            binding.tvTitle.text = onBoarding.title
            binding.tvDesk.text = onBoarding.desc

            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.skip.isVisible = adapterPosition != data.lastIndex
            binding.btnStart.setOnClickListener{
                onClick()
            }
            binding.skip.setOnClickListener{
                onClick()
            }
        }

    }
}