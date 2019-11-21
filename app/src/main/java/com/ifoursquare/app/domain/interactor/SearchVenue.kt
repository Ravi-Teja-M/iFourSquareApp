package com.ifoursquare.app.domain.interactor

import com.ifoursquare.app.data.model.venues.VenueModel
import com.ifoursquare.app.data.repositories.SearchVenueRepository
import com.ifoursquare.app.domain.usecases.SearchVenueUseCase

class SearchVenue : SearchVenueUseCase {

    private val repository :SearchVenueRepository  =  SearchVenueRepository.get()


    companion object {
        fun get() = SearchVenue()
    }

    override suspend fun searchVenueByString(searchedString: String?) : VenueModel {

       return repository.searchVenueByString(searchedString)
    }

    override suspend fun searchVenueByLocation(location: String?) : VenueModel {

        return repository.searchVenueByLocation(location)

    }


}