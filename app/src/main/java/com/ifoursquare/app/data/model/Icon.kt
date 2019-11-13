package com.ifoursquare.app.data.model


import com.google.gson.annotations.SerializedName

data class Icon(
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("suffix")
    val suffix: String
){

    fun get64x64SizedImage():String {
        return "${prefix}64${suffix} "
    }
}