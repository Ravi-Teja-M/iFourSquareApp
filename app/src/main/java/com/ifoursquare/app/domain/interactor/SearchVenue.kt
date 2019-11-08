package com.ifoursquare.app.domain.interactor

import android.location.Location
import com.ifoursquare.app.data.repositories.SearchVenueRepository
import com.ifoursquare.app.domain.usecases.SearchVenueUseCase

class SearchVenue : SearchVenueUseCase {

    val repository =   SearchVenueRepository.instance()

    companion object {
        fun get() = SearchVenue()
    }

    override fun searchVenueByString(searchedString: String?) {

        repository.searchVenueByString(searchedString)
    }

    override fun searchVenueByLocation(location: Location?) {

         repository.searchVenueByLocation(location)

    }


}