package com.example.fooddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fooddy.databinding.ActivityMainBinding
import com.example.fooddy.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : BottomNavigationView
    private lateinit var binding2 : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding2 = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        replaceFragment(HomeFragment())

        binding = findViewById(R.id.bottomNavigationView)

        binding.setOnItemSelectedListener { menuItem ->

            when(menuItem.itemId) {
                R.id.homeFragment -> {
                    replaceFragment(HomeFragment())

                }
                R.id.cartFragment -> {
                    replaceFragment(CartFragment())
                }
                R.id.searchFragment -> {
                    replaceFragment(SearchFragment())
                }
                R.id.historyFragment -> {
                    replaceFragment(HistoryFragment())
                }
                R.id.profileFragment -> {
                    replaceFragment(ProfileFragment())
                }
                else -> {}
            }
            true
        }


        binding2.bellIcon.setOnClickListener{
            val bottomSheetDialog = NotificationBottomFragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
    }

    private fun replaceFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()

    }

}