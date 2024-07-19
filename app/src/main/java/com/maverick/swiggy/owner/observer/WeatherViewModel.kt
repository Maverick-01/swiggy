package com.maverick.swiggy.owner.observer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.maverick.swiggy.data.CitySearchItem
import com.maverick.swiggy.owner.repo.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel:ViewModel() {

    private val repo = WeatherRepository()

    private val _getSearchCityObserver = MutableLiveData<List<CitySearchItem>>()
    val getSearchCityObserver: LiveData<List<CitySearchItem>> = _getSearchCityObserver

    fun fetchSearchCity(city:String){
        //change to viewmodelscope. was not able to get viewmodelscope despite adding coroutine dependency
        CoroutineScope(Dispatchers.IO).launch {
            val response = repo.fetchSearchCity(city = city)
            if (response.isSuccessful){
                _getSearchCityObserver.postValue(response.body())
            }
        }
    }
}