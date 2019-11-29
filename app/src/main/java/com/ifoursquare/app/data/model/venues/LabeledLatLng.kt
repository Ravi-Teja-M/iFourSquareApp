package com.ifoursquare.app.data.model.venues


import com.google.gson.annotations.SerializedName

data class LabeledLatLng(
    @SerializedName("label")
    val label: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double
)