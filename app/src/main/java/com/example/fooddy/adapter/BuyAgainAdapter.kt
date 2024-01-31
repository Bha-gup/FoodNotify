package com.example.fooddy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddy.adapter.BuyAgainAdapter.*
import com.example.fooddy.databinding.BuyAgainItemBinding


class BuyAgainAdapter(private val buyAgainFoodName:ArrayList<String>,
                      private val buyAgainFoodPrice:ArrayList<String>,
                      private val buyAgainImage:ArrayList<Int>) :
    RecyclerView.Adapter<BuyAgainViewHolder>(){




    override fun getItemCount(): Int = buyAgainFoodName.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(buyAgainFoodName[position],buyAgainFoodPrice[position],buyAgainImage[position])
    }


    class BuyAgainViewHolder (private val binding: BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(FoodName: String, FoodPrice: String, FoodImage: Int) {
            binding.buyFoodName.text = FoodName
            binding.buyFoodPrice.text = FoodPrice
            binding.buyFoodImage.setImageResource(FoodImage)
        }


    }


}