package com.example.fooddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddy.databinding.ActivitySignBinding

class signActivity : AppCompatActivity() {

    private val binding : ActivitySignBinding by lazy{
        ActivitySignBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.alreadyhaveaccount.setOnClickListener{

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.createAccount.setOnClickListener {
            val intent = Intent(this,NavigationLocation::class.java)
            startActivity(intent)
        }


    }
}