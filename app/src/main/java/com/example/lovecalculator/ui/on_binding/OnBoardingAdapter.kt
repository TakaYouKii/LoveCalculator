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
        OnBoarding("Добро пожаловать в LoveCalculator!","Откройте для себя новый способ узнавать, насколько сильно вас связывает с вашей второй половинкой.", "https://new-retail.ru/upload/iblock/d57/xd5711742b0ef7d9366df4cd884c99388.jpg.pagespeed.ic.tFqhvupYpn.jpg"),
        OnBoarding("Получите результат", "Наш алгоритм вычислит уровень вашей совместимости и подскажет, насколько вы подходите друг другу.", "https://www.meme-arsenal.com/memes/130b1529d4ba6b49c647ff17e9dc6b17.jpg"),
        OnBoarding("Введите имена", "Введите свое имя и имя вашей возлюбленной, чтобы начать расчет вашей любви.", "https://zolotoy.ru/wp-content/uploads/2021/02/850-17.jpg"),
        OnBoarding("Откройте для себя секреты любви", "Получите советы и рекомендации, чтобы сделать вашу любовь еще крепче и гармоничнее.", "https://www.meme-arsenal.com/memes/6c379e54d2de47b72129a1c46cf386e0.jpg")
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