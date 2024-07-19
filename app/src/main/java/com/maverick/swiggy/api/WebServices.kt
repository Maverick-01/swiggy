package com.maverick.swiggy.api

import com.maverick.swiggy.data.CitySearchItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface WebServices {
    @GET
    suspend fun fetchSearchCity(
        @Url url: String,
        @Query("q") city: String,
    ): Response<List<CitySearchItem>>
}