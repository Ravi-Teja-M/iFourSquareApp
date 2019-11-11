package com.ifoursquare.app.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ifoursquare.app.data.model.Venue
import com.ifoursquare.app.domain.interactor.SearchVenue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchPlacesViewModel : ViewModel() {

    val mutabablePlacesList: MutableLiveData<List<Venue>> = MutableLiveData()


    fun  searchVenuesByLocation(input: String?) {
        val searchVenueUseCase =  SearchVenue.get()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val venueModel = searchVenueUseCase.searchVenueByLocation(input)
                withContext(Dispatchers.Main) {
                    mutabablePlacesList.value = venueModel?.response.venues
                }
            }
        }
    }
 }
