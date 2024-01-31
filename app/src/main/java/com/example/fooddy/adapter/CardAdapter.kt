package com.example.fooddy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddy.databinding.CartviewBinding

class CardAdapter(private val cartItems:MutableList<String>,
                  private val CartItemPrice:MutableList<String>,
                  private var CartImage:MutableList<Int>
                  ):RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private val itemQualities = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CartviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size

    inner class CardViewHolder(private val binding: CartviewBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQualities[position]
                cartFoodName.text = cartItems[position]
                cartFoodPrice.text = CartItemPrice[position]
                Itemquantity.text = quantity.toString()

                minusButtton.setOnClickListener{
                    decreaseQuantity(position)
                }
                plusbutton.setOnClickListener {
                    increaseQuantity(position)
                }

                deleteItems.setOnClickListener{
                    val itemPosition = adapterPosition
                    if(itemPosition != RecyclerView.NO_POSITION){
                        deleteItemsAll(itemPosition)
                    }
                }

            }
        }

        private fun decreaseQuantity(position: Int){
            if(itemQualities[position] > 1){
                itemQualities[position]--
                binding.Itemquantity.text = itemQualities[position].toString()
            }
        }

        private fun increaseQuantity(position: Int){
            if(itemQualities[position] < 10){
                itemQualities[position]++
                binding.Itemquantity.text = itemQualities[position].toString()
            }
        }
        private fun deleteItemsAll(position: Int){
            cartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeRemoved(position,cartItems.size)
        }


    }

}