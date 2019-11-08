package com.ifoursquare.app.data.model


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("beenHere")
    val beenHere: BeenHere,
    @SerializedName("categories")
    val categories: List<Category>,
    @SerializedName("contact")
    val contact: Contact,
    @SerializedName("hasPerk")
    val hasPerk: Boolean,
    @SerializedName("hereNow")
    val hereNow: HereNow,
    @SerializedName("id")
    val id: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("referralId")
    val referralId: String,
    @SerializedName("stats")
    val stats: Stats,
    @SerializedName("venueChains")
    val venueChains: List<Any>,
    @SerializedName("venuePage")
    val venuePage: VenuePage,
    @SerializedName("verified")
    val verified: Boolean
)