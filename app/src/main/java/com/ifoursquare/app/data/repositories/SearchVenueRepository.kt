package com.ifoursquare.app.data.repositories

import com.ifoursquare.app.data.model.venues.VenueModel
import com.ifoursquare.app.domain.usecases.SearchVenueUseCase
import com.ifoursquare.app.networking.ApiClient
import com.ifoursquare.app.networking.services.endpoints.VenueSearchByLocationService
import retrofit2.Retrofit
import javax.inject.Inject

class SearchVenueRepository @Inject constructor(var retrofit: Retrofit) : SearchVenueUseCase {

    override suspend fun searchVenueByString(searchedString: String?) : VenueModel {
        val service = retrofit.create(VenueSearchByLocationService::class.java)
        return service.venueSearchNearBy(searchedString!!)
    }

    override  suspend  fun searchVenueByLocation(location: String?) : VenueModel {

        val service = retrofit.create(VenueSearchByLocationService::class.java)
        return service.venueSearchByLocation(location!!)
    }


}