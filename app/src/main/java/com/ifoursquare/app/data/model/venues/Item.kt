package com.ifoursquare.app.data.model.venues


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("unreadCount")
    val unreadCount: Int
)