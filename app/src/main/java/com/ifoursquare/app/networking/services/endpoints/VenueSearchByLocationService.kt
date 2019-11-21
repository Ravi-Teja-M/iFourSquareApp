package com.ifoursquare.app.networking.services.endpoints

import com.ifoursquare.app.data.model.venues.VenueModel
import retrofit2.http.GET
import retrofit2.http.Query

interface VenueSearchByLocationService {

    @GET("venues/search")
    suspend fun venueSearchByLocation(@Query("ll") latLong: String ) : VenueModel

    @GET("venues/search")
    suspend fun venueSearchNearBy(@Query("near") nearbyPlace: String ) : VenueModel
}