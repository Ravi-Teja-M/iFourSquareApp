package com.ifoursquare.app.presentation.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
 import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifoursquare.app.IApplication
import com.ifoursquare.app.R
import com.ifoursquare.app.databinding.SearchPlacesFragmentBinding
import com.ifoursquare.app.presentation.activities.MainActivity
import com.ifoursquare.app.presentation.adapters.SearchListViewAdapter
import com.ifoursquare.app.presentation.viewmodels.SearchPlacesViewModel

class SearchPlacesFragment : Fragment() {

    private lateinit var binding: SearchPlacesFragmentBinding
    private lateinit var viewModel: SearchPlacesViewModel
    private var mSearchListAdapter: SearchListViewAdapter = SearchListViewAdapter()

    companion object {
        fun newInstance() = SearchPlacesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.search_places_fragment, container, false)

        viewModel = ViewModelProviders.of(this).get(SearchPlacesViewModel::class.java)
        binding.searchViewModel = viewModel

        return binding.root
    }


    private fun initViewsWithActionAndData() {

        initRecyclerView()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                //val input = query @TODO

                query?.let{
                    //viewModel.searchVenueByInput(query)
                }

               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

              return false
            }
        })
    }

    private fun initRecyclerView() {
        (binding.recyclerView).apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = mSearchListAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewsWithActionAndData()
        observeDataSetChanged()
    }

    private fun observeDataSetChanged() {
        viewModel.mutablePlacesList.observe(this, Observer { dataSet ->
            mSearchListAdapter.updateData(dataSet)
            mSearchListAdapter.notifyDataSetChanged()
        })

    }
}
