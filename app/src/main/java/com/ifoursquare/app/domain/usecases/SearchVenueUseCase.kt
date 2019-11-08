package com.ifoursquare.app.domain.usecases

import android.location.Location

interface SearchVenueUseCase : UseCase {

    fun searchVenueByString( searchedString: String?)

    fun searchVenueByLocation(location: Location?)
}