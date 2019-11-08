package com.ifoursquare.app.data.repositories

import android.location.Location
import com.ifoursquare.app.data.model.VenueModel
import com.ifoursquare.app.domain.usecases.SearchVenueUseCase
import com.ifoursquare.app.networking.ApiClient
import com.ifoursquare.app.networking.services.endpoints.VenueSearchByLocationService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchVenueRepository : SearchVenueUseCase{

    companion object {
         private lateinit var sInstance : SearchVenueRepository
         fun instance() : SearchVenueRepository {
             if(sInstance == null) {
                  sInstance = SearchVenueRepository()
             }
             return sInstance
         }
     }


    override fun searchVenueByLocation(location: Location?) {

        location?.let {
            val service =  ApiClient.RetroInstance.get().create(VenueSearchByLocationService::class.java)
            val latLongBuilder = "${location.latitude},${location.longitude} "
            service.venueSearchByLocation(latLongBuilder).enqueue(object : Callback<VenueModel>{
                override fun onFailure(call: Call<VenueModel>, t: Throwable) {

                }

                override fun onResponse(call: Call<VenueModel>, response: Response<VenueModel>) {
                    if (response.isSuccessful){
                        val data = response?.body()
                        data?.response?.venues
                    }
                }
            })
        }
    }


    override fun searchVenueByString(searchedString: String?) {

    }


}