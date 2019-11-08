package com.ifoursquare.app.data.model


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("confident")
    val confident: Boolean,
    @SerializedName("venues")
    val venues: List<Venue>
)