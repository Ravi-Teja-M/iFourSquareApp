package com.ifoursquare.app.data.model


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("checkinsCount")
    val checkinsCount: Int,
    @SerializedName("tipCount")
    val tipCount: Int,
    @SerializedName("usersCount")
    val usersCount: Int
)