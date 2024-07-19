package com.maverick.swiggy.owner.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.maverick.swiggy.R
import com.maverick.swiggy.data.CitySearchItem
import com.maverick.swiggy.databinding.ActivityMainBinding
import com.maverick.swiggy.owner.adapter.Adapter
import com.maverick.swiggy.owner.observer.WeatherViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WeatherViewModel
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]


        binding.button.setOnClickListener {
            Log.d("pune", binding.searchText.text.toString().trim())
            viewModel.fetchSearchCity(city = binding.searchText.text.toString().trim())
            binding.progressBar.visibility = View.VISIBLE
        }

        searchCityObserver()

        adapter = Adapter { item, action ->
            when (action) {
                "onClick" -> {
                    Toast.makeText(this,"You have Clicked ${item.localizedName}.",Toast.LENGTH_SHORT).show()
                }
            }
        }.also {
            binding.recycler.adapter = it
        }
    }

    private fun searchCityObserver() {
        viewModel.getSearchCityObserver.observe(this) {
            Log.d("pune", it.toString())
            adapter.searchCity = it as ArrayList<CitySearchItem>
            adapter.notifyDataSetChanged()
            binding.progressBar.visibility = View.GONE
        }
    }
    //Glide.with(context).load(data.url).into(binding.imageview)
}