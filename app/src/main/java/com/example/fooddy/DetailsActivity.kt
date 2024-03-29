package com.example.fooddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddy.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuImage",0)
        binding.detailsFoddName.text = foodName
        binding.DetailsFoodImage.setImageResource(foodImage)

        binding.DetailsBackButton.setOnClickListener {
            finish()
        }

    }
}