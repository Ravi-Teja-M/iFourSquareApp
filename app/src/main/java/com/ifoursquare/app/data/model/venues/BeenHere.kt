package com.ifoursquare.app.data.model.venues


import com.google.gson.annotations.SerializedName

data class BeenHere(
    @SerializedName("lastCheckinExpiredAt")
    val lastCheckinExpiredAt: Int
)