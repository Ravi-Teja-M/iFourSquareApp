package com.ifoursquare.app.data.model.venues


import com.google.gson.annotations.SerializedName

data class Contact(
    @SerializedName("formattedPhone")
    val formattedPhone: String,
    @SerializedName("phone")
    val phone: String
)