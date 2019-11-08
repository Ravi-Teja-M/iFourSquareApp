package com.ifoursquare.app.presentation.fragments

import android.location.Location
import androidx.lifecycle.ViewModel
import com.ifoursquare.app.domain.interactor.SearchVenue

class SearchPlacesViewModel : ViewModel() {

    fun searchVenuesByQuery(input: String?) {
       val searchVenueUseCase =  SearchVenue.get()
       searchVenueUseCase.searchVenueByString(input)


    }

    fun searchVenuesByLocation(input: Location?) {
        val searchVenueUseCase =  SearchVenue.get()
        searchVenueUseCase.searchVenueByLocation(input)

    }
 }
