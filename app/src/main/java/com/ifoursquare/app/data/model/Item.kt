package com.ifoursquare.app.data.model


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("unreadCount")
    val unreadCount: Int
)