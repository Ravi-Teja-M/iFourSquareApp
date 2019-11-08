package com.ifoursquare.app.data.model


import com.google.gson.annotations.SerializedName

data class Notification(
    @SerializedName("item")
    val item: Item,
    @SerializedName("type")
    val type: String
)