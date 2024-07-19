package com.maverick.swiggy.owner.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maverick.swiggy.R
import com.maverick.swiggy.data.CitySearchItem
import com.maverick.swiggy.databinding.ItemSearchCityBinding

class Adapter(val callback: (item: CitySearchItem, action: String) -> (Unit)) :
    RecyclerView.Adapter<Adapter.AdapterViewHolder>(
    ) {
    var searchCity = ArrayList<CitySearchItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val binding =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search_city, parent, false)
        return AdapterViewHolder(binding.rootView)
    }

    override fun getItemCount(): Int {
        return searchCity.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(searchCity[position])
    }

    inner class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemSearchCityBinding.bind(itemView)
        fun bind(citySearchItem: CitySearchItem) {
            binding.data = citySearchItem
            binding.root.setOnClickListener {
                callback.invoke(citySearchItem, "onClick")
            }
        }
    }
}