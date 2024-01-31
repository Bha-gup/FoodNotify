package com.example.fooddy.adapter

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddy.DetailsActivity
import com.example.fooddy.adapter.MenuAdapter.*
import com.example.fooddy.databinding.MenuitemBinding

class MenuAdapter(private val menuItemsName:MutableList<String>,
                  private val menuItemPrice:MutableList<String>,
                  private val menuImage:MutableList<Int>,
                  private val requireContext:Context): RecyclerView.Adapter<MenuViewHolder>() {

    private val itemClickListener : OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder (private val binding: MenuitemBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION){
                    itemClickListener?.OnItemClick(position)
                }
                //setonclick listener on the details item
                val intent = Intent (requireContext,DetailsActivity::class.java)
                intent.putExtra("MenuItemName",menuItemsName.get(position))
                intent.putExtra("MenuImage",menuImage.get(position))
                requireContext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                MenufoodName.text = menuItemsName[position]
                MenufoodPrice.text = menuItemPrice[position]
                MenufoodImage.setImageResource(menuImage[position])

            }
        }
    }

interface OnClickListener{
    fun OnItemClick(position: Int)
}

}
