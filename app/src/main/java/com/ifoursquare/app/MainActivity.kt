package com.ifoursquare.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ifoursquare.app.databinding.ActivityMainBinding
import com.ifoursquare.app.presentation.fragments.NearByPlacesFragment
import com.ifoursquare.app.presentation.fragments.SearchPlacesFragment

class MainActivity : AppCompatActivity() {

    private var currentSelectedFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initBottomBarViewWithActions(binding)

        addSearchPlacesFragment()
    }

    private fun initBottomBarViewWithActions( binding :ActivityMainBinding ){
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.favourites -> {

                }

                R.id.search_by_input -> {
                    addSearchPlacesFragment()
                }

                R.id.near_by_location -> {
                    addNearByPlacesFragment()
                }
            }
            true
        }
    }

    private fun addSearchPlacesFragment() {
        val searchPlacesFragment: SearchPlacesFragment = SearchPlacesFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container, searchPlacesFragment).commit()
        supportFragmentManager.beginTransaction().setPrimaryNavigationFragment(searchPlacesFragment)
        currentSelectedFragment = searchPlacesFragment
    }


    private fun addNearByPlacesFragment() {
        val nearByPlacesFragment: NearByPlacesFragment = NearByPlacesFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container, nearByPlacesFragment).commit()
         currentSelectedFragment = nearByPlacesFragment
    }

    override fun onBackPressed() {
        if(currentSelectedFragment is SearchPlacesFragment){
            super.onBackPressed()
        }
        else{
         }
    }
}
