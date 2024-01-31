package com.example.fooddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddy.databinding.ActivityPayOutAcitivityBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class PayOutAcitivity : AppCompatActivity() {

    private lateinit var binding : ActivityPayOutAcitivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPayOutAcitivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.PlaceMyOrder.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
        binding.PayOutBackButton.setOnClickListener {
            finish()
        }

    }
}