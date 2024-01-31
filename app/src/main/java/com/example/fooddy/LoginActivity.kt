package com.example.fooddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fooddy.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.loginbutton.setOnClickListener{

            val intent = Intent(this,NavigationLocation::class.java)
            startActivity(intent)
        }

        binding.donthaveaccount.setOnClickListener{

            val intent = Intent(this,signActivity::class.java)
            startActivity(intent)
        }

    }
}