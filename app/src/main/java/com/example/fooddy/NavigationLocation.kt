package com.example.fooddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.fooddy.databinding.ActivityNavigationLocationBinding

class NavigationLocation : AppCompatActivity() {

    private val binding : ActivityNavigationLocationBinding by lazy{
        ActivityNavigationLocationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val locationList = arrayOf("Bhopal","Indore","Gwalior","Jaipur","Mumbai","Chennai","Bengaluru","Jhansi")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)

        val autoCompleteTextView = binding.listoflocation
        autoCompleteTextView.setAdapter(adapter)

        binding.LocationNext.setOnClickListener {
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}