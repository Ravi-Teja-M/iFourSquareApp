package com.ifoursquare.app.data.model


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("code")
    val code: Int,
    @SerializedName("requestId")
    val requestId: String
)