package com.ifoursquare.app.presentation.activities


import android.content.Context
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ifoursquare.app.R
import com.ifoursquare.app.databinding.ActivityMainBinding
import com.ifoursquare.app.presentation.fragments.NearByPlacesFragment
import com.ifoursquare.app.presentation.fragments.SearchPlacesFragment
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseActivity() {

    private var currentSelectedFragment: Fragment? = null

    @Inject
    @Named("getApplicationContext")
    lateinit var contextX: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        initBottomBarViewWithActions(binding)

        //addNearByPlacesFragment()
        getCurrentLocation()
    }

    private fun getCurrentLocation() {

    }


    private fun initBottomBarViewWithActions(binding: ActivityMainBinding) {
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
        var searchPlacesFragment: SearchPlacesFragment? =   supportFragmentManager.findFragmentByTag("SearchPlacesFragment") as? SearchPlacesFragment
        if (searchPlacesFragment == null) {
            searchPlacesFragment = SearchPlacesFragment.newInstance()
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, searchPlacesFragment, "SearchPlacesFragment")
            .addToBackStack("SearchPlacesFragment")
            .commit()
        supportFragmentManager.beginTransaction().setPrimaryNavigationFragment(searchPlacesFragment)
        currentSelectedFragment = searchPlacesFragment
    }

    private fun addNearByPlacesFragment() {

        var nearByPlacesFragment: NearByPlacesFragment? =
            supportFragmentManager.findFragmentByTag("NearByPlacesFragment") as? NearByPlacesFragment
        if (nearByPlacesFragment == null) {
            nearByPlacesFragment = NearByPlacesFragment.newInstance()
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, nearByPlacesFragment,"NearByPlacesFragment")
            .addToBackStack("NearByPlacesFragment")
            .commit()
        currentSelectedFragment = nearByPlacesFragment
    }

    override fun onBackPressed() {
        if (currentSelectedFragment is SearchPlacesFragment) {
            super.onBackPressed()
        } else {

        }
    }
}
