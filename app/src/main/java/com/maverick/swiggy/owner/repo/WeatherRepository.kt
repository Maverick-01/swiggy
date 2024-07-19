package com.maverick.swiggy.owner.repo

import com.maverick.swiggy.api.Retrofit
import com.maverick.swiggy.utlis.URLs

class WeatherRepository {
    private val api = Retrofit().webService
    suspend fun fetchSearchCity(city:String) = api.fetchSearchCity(url = URLs.FETCH_SEARCH_CITY, city = city)
}