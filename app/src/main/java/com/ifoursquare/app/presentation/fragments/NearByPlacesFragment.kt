package com.ifoursquare.app.presentation.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ifoursquare.app.R
import com.ifoursquare.app.presentation.viewmodels.NearByPlacesViewModel

class NearByPlacesFragment : BaseFragment() {

    companion object {
        fun newInstance() = NearByPlacesFragment()
    }

    private lateinit var viewModel: NearByPlacesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.near_by_places_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NearByPlacesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
