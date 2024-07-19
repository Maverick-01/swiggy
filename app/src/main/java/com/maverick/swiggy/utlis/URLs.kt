package com.maverick.swiggy.utlis

import com.maverick.swiggy.utlis.Constants.Companion.API_KEY
import com.maverick.swiggy.utlis.Constants.Companion.BASE_URL

class URLs {
    companion object{
        const val FETCH_SEARCH_CITY = "$BASE_URL/locations/v1/cities/search?apikey=$API_KEY"
    }
}