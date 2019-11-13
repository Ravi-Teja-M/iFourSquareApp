package com.ifoursquare.app.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ifoursquare.app.data.model.Venue
import com.ifoursquare.app.data.model.VenueModel
import com.ifoursquare.app.domain.interactor.SearchVenue
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SearchPlacesViewModel : ViewModel() , CoroutineScope{

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job = Job()

    val mutablePlacesList: MutableLiveData<List<Venue>> = MutableLiveData()
    private val searchVenueUseCase =  SearchVenue.get()

    fun  searchVenuesByLocation(input: String) {

        launch(Dispatchers.Main) {
            var venueModel: VenueModel? = null
            launch(Dispatchers.IO) {
                venueModel = searchVenueUseCase.searchVenueByLocation(input)
            }
            mutablePlacesList.value = venueModel?.response?.venues
        }
    }

    fun searchVenueByInput(input:String) {

        launch(Dispatchers.Main){

            withContext(Dispatchers.IO) {

                val venueModel = searchVenueUseCase.searchVenueByString(input)

                withContext(Dispatchers.Main){
                    mutablePlacesList.value = venueModel?.response?.venues
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
