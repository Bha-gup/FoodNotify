package com.example.fooddy.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddy.PayOutAcitivity
import com.example.fooddy.R
import com.example.fooddy.adapter.CardAdapter
import com.example.fooddy.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var binding:FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater,container,false)

        val cartFoodName = listOf("burger","pizza","sanwich","momo","Noodles","Thali","Rolls")
        val cartItemPrise = listOf("$5","$6","$8","$5","$6","$8","$12")
        val cartImage = listOf(

            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu7
        )
        val adapter = CardAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrise),ArrayList(cartImage))
        binding.RecyclerCardItems.layoutManager = LinearLayoutManager(requireContext())
        binding.RecyclerCardItems.adapter = adapter

        binding.proceed.setOnClickListener {
            val intent = Intent(requireContext(),PayOutAcitivity::class.java)
            startActivity(intent)
        }



        return binding.root
    }

}