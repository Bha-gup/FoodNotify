package com.example.fooddy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddy.adapter.notificationAdapter
import com.example.fooddy.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationBottomFragment : BottomSheetDialogFragment(){
    private lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)

        val notification = listOf("Your order has been Cancelled Successfully","Order has been taken by the driver","Congrats Your Order Placed")
        val notificationImages = listOf(R.drawable.sademoji,R.drawable.truck,R.drawable.congrats)

        val adapter = notificationAdapter(
            ArrayList(notification),
            ArrayList(notificationImages)
        )

        binding.notificationRecycleView.layoutManager = LinearLayoutManager(requireContext())
        binding.notificationRecycleView.adapter = adapter
        return binding.root
    }

}