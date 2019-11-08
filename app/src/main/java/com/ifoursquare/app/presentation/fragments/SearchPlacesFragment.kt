package com.ifoursquare.app.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifoursquare.app.R
import com.ifoursquare.app.databinding.SearchPlacesFragmentBinding
import com.ifoursquare.app.presentation.adapters.SearchListViewAdapter

class SearchPlacesFragment : Fragment() {

    private lateinit var binding: SearchPlacesFragmentBinding
    private lateinit var viewModel: SearchPlacesViewModel
    private lateinit var mSearchListAdapter: SearchListViewAdapter

    companion object {
        fun newInstance() = SearchPlacesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.search_places_fragment, container, false)
        initViewsWithActionAndData()
        return binding.root
    }

    private fun initViewsWithActionAndData() {
        binding.searchViewModel = viewModel
        initRecyclerView()
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                val input = query
                viewModel.searchVenuesByQuery(input)

               return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {


              return false
            }
        })
    }

    private fun initRecyclerView() {
        (binding.recyclerView)?.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = SearchListViewAdapter()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchPlacesViewModel::class.java)
    }
}
