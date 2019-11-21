package com.ifoursquare.app.data.model.venues


import com.google.gson.annotations.SerializedName

data class HereNow(
    @SerializedName("count")
    val count: Int,
    @SerializedName("groups")
    val groups: List<Any>,
    @SerializedName("summary")
    val summary: String
)