package com.ifoursquare.app.networking.services.endpoints

import com.ifoursquare.app.data.model.VenueModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface VenueSearchByLocationService {

    @GET("venues/search")
    suspend fun venueSearchByLocation(@Query("ll") latLong: String ) : VenueModel

    @GET("venues/search")
    suspend fun venueSearchNearBy(@Query("near") nearbyPlace: String ) : VenueModel
}