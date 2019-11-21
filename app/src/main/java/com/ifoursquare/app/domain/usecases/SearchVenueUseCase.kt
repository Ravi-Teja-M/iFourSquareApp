package com.ifoursquare.app.domain.usecases

import com.ifoursquare.app.data.model.venues.VenueModel

interface SearchVenueUseCase : UseCase {

    suspend fun searchVenueByString( searchedString: String?) : VenueModel

    suspend fun searchVenueByLocation(location: String?) : VenueModel
}