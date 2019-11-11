package com.ifoursquare.app.data.repositories

import android.location.Location
import com.ifoursquare.app.data.model.VenueModel
import com.ifoursquare.app.domain.usecases.SearchVenueUseCase
import com.ifoursquare.app.networking.ApiClient
import com.ifoursquare.app.networking.services.endpoints.VenueSearchByLocationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchVenueRepository : SearchVenueUseCase {
    override suspend fun searchVenueByString(searchedString: String?): VenueModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        private lateinit var sInstance: SearchVenueRepository
        fun instance(): SearchVenueRepository {
            if (sInstance == null) {
                sInstance = SearchVenueRepository()
            }
            return sInstance
        }
    }


    override suspend fun searchVenueByLocation(location: String?): VenueModel {
        val service = ApiClient.RetroInstance.get().create(VenueSearchByLocationService::class.java)
         return service.venueSearchByLocation(location!!)
    }
}