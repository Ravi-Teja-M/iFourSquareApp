package com.ifoursquare.app.data.repositories

import com.ifoursquare.app.data.model.venues.VenueModel
import com.ifoursquare.app.domain.usecases.SearchVenueUseCase
import com.ifoursquare.app.networking.ApiClient
import com.ifoursquare.app.networking.services.endpoints.VenueSearchByLocationService

class SearchVenueRepository : SearchVenueUseCase {
    override suspend fun searchVenueByString(searchedString: String?) : VenueModel {
        val service = ApiClient.RetroInstance.get().create(VenueSearchByLocationService::class.java)
        return service.venueSearchNearBy(searchedString!!)
    }

    override  suspend  fun searchVenueByLocation(location: String?) : VenueModel {

        val service = ApiClient.RetroInstance.get().create(VenueSearchByLocationService::class.java)
        return service.venueSearchByLocation(location!!)
    }

    companion object {
       fun get() = SearchVenueRepository()

    }
}