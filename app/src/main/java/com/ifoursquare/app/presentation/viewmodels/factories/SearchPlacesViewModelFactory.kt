package com.ifoursquare.app.presentation.viewmodels.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ifoursquare.app.data.repositories.SearchVenueRepository
import com.ifoursquare.app.domain.interactor.SearchVenue
import com.ifoursquare.app.presentation.viewmodels.SearchPlacesViewModel
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class SearchPlacesViewModelFactory @Inject constructor(private val repository: SearchVenueRepository) :  ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchPlacesViewModel(SearchVenue(repository)) as T
    }
}