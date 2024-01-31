package com.example.fooddy.adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddy.DetailsActivity
import com.example.fooddy.adapter.popularAdapter.*
import com.example.fooddy.databinding.PopulartemsBinding

class popularAdapter(private val items:List<String>,
                     private val price : List<String>,
                     private val image:List<Int>,
                     private val requireContext: Context) : RecyclerView.Adapter<PopularViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopulartemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)

        holder.itemView.setOnClickListener {

            val intent = Intent (requireContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName",item)
            intent.putExtra("MenuImage",images)
            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
    class PopularViewHolder (private val binding : PopulartemsBinding): RecyclerView.ViewHolder(binding.root) {
        private val imageView = binding.foodImage
        fun bind(item: String,price: String, images: Int) {
            binding.foodName.text = item
            binding.foodPrice.text = price
            imageView.setImageResource(images)
        }
    }


}