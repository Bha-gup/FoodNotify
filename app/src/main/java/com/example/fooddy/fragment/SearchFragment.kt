package com.example.fooddy.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddy.R
import com.example.fooddy.adapter.MenuAdapter
import com.example.fooddy.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val searchFoodName = listOf(
        "burger","pizza","sanwich","momo","Noodles","Thali","Rolls"
    )
    private val searchPrice = listOf("$5","$6","$8","$5","$6","$8","$12")
    private val searchImage = listOf(

        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu7
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    private val filterMenuFoodName = mutableListOf<String>()
    private val filterMenuPrice = mutableListOf<String>()
    private val filterMenuImage = mutableListOf<Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)

        adapter = MenuAdapter(filterMenuFoodName,filterMenuPrice,filterMenuImage,requireContext())
        binding.MenuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.MenuRecyclerView.adapter = adapter

        setupSearchView()

        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuPrice.clear()
        filterMenuImage.clear()

        filterMenuFoodName.addAll(searchFoodName)
        filterMenuPrice.addAll(searchPrice)
        filterMenuImage.addAll(searchImage)
        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String): Boolean {
                filterMenuItem(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItem(newText)
                return true
            }

        })
    }

    private fun filterMenuItem(query:String) {
        filterMenuFoodName.clear()
        filterMenuPrice.clear()
        filterMenuImage.clear()

        searchFoodName.forEachIndexed{
            index,foodName ->
            if(foodName.contains(query,ignoreCase = true)){

                filterMenuFoodName.add(foodName)
                filterMenuPrice.add(searchPrice[index])
                filterMenuImage.add(searchImage[index])
            }
        }

        adapter.notifyDataSetChanged()

    }

}