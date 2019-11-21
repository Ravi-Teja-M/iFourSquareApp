package com.ifoursquare.app.data.model.venues


import com.google.gson.annotations.SerializedName

data class VenueModel(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("notifications")
    val notifications: List<Notification>,
    @SerializedName("response")
    val response: Response
)