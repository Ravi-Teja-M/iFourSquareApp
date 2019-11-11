package com.ifoursquare.app.domain.usecases

import android.location.Location
import com.ifoursquare.app.data.model.VenueModel

interface SearchVenueUseCase : UseCase {

    suspend fun searchVenueByString( searchedString: String?) : VenueModel

    suspend fun searchVenueByLocation(location: String?) : VenueModel
}