package com.ifoursquare.app.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ifoursquare.app.data.model.venues.Venue
import com.ifoursquare.app.data.model.venues.VenueModel
import com.ifoursquare.app.domain.interactor.SearchVenue
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SearchPlacesViewModel @Inject constructor(private val searchVenueUseCase: SearchVenue) : ViewModel(), CoroutineScope {

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    internal val mutablePlacesList: MutableLiveData<List<Venue>> = MutableLiveData()


   // private var searchVenueUseCase: SearchVenue = SearchVenue()

    @Suppress("unused")
    fun searchVenuesByLocation(input: String) {

        launch(Dispatchers.Main) {
            var venueModel: VenueModel? = null
            launch(Dispatchers.IO) {
                venueModel = searchVenueUseCase.searchVenueByLocation(input)
            }
            mutablePlacesList.value = venueModel?.response?.venues
        }
    }

    fun searchVenueByInput(input: String) {

        launch(Dispatchers.Main) {

            withContext(Dispatchers.IO) {

                val venueModel = searchVenueUseCase.searchVenueByString(input)

                withContext(Dispatchers.Main) {
                    mutablePlacesList.value = venueModel.response.venues
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
