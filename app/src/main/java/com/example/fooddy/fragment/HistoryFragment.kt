package com.example.fooddy.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddy.R
import com.example.fooddy.adapter.BuyAgainAdapter
import com.example.fooddy.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var binding : FragmentHistoryBinding
    private lateinit var buyAgainAdapter : BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setupRecycleView()
        return binding.root
    }

    private fun setupRecycleView(){
        val buyAgainFoodName = arrayListOf("Food 2","Food 2","Food 3")
        val buyAgainFoodPrice = arrayListOf("$5","$6","$8")
        val buyAgainImage = arrayListOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3)
        buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainImage)
        binding.buyAgainRecycleView.adapter = buyAgainAdapter
        binding.buyAgainRecycleView.layoutManager = LinearLayoutManager(requireContext())
    }

}