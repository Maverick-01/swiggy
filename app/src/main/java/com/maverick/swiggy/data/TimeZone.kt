package com.maverick.swiggy.data


import com.google.gson.annotations.SerializedName

data class TimeZone(
    @SerializedName("Code")
    val code: String? = null,
    @SerializedName("GmtOffset")
    val gmtOffset: Double? = null,
    @SerializedName("IsDaylightSaving")
    val isDaylightSaving: Boolean? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("NextOffsetChange")
    val nextOffsetChange: Any? = null
)