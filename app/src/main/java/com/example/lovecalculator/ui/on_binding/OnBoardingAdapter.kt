package com.example.lovecalculator.ui.on_binding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.OnBoardingItemsBinding
import com.example.lovecalculator.model.OnBoarding

class OnBoardingAdapter(private val onClick:()-> Unit): RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>(){

    private val data = arrayListOf<OnBoarding>(
        OnBoarding("Добро пожаловать в LoveCalculator!","Откройте для себя новый способ узнавать, насколько сильно вас связывает с вашей второй половинкой.", R.raw.bear_animation),
        OnBoarding("Получите результат", "Наш алгоритм вычислит уровень вашей совместимости и подскажет, насколько вы подходите друг другу.", R.raw.cat),
        OnBoarding("Введите имена", "Введите свое имя и имя вашей возлюбленной, чтобы начать расчет вашей любви.", R.raw.love_emoji),
        OnBoarding("Откройте для себя секреты любви", "Получите советы и рекомендации, чтобы сделать вашу любовь еще крепче и гармоничнее.", R.raw.geese_in_love)
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

            onBoarding.animation?.let {
                binding.laBoard.setAnimation(it)
            }
            binding.laBoard.playAnimation()
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