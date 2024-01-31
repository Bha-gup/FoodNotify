package com.example.fooddy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddy.adapter.MenuAdapter
import com.example.fooddy.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding : FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        binding.menuBack.setOnClickListener {
            dismiss()
        }


        val MenuFoodName = listOf("burger","pizza","sanwich","momo","Noodles","Thali","Rolls")
        val MenuItemPrise = listOf("$5","$6","$8","$5","$6","$8","$12")
        val MenuImage = listOf(

            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu7
        )
        val adapter = MenuAdapter(ArrayList(MenuFoodName),ArrayList(MenuItemPrise),ArrayList(MenuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root

    }

}