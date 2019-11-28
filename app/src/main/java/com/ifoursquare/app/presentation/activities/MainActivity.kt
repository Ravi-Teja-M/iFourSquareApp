package com.ifoursquare.app.presentation.activities


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ifoursquare.app.IApplication
import com.ifoursquare.app.R
import com.ifoursquare.app.data.model.login.LoginModel
import com.ifoursquare.app.databinding.ActivityMainBinding
import com.ifoursquare.app.presentation.fragments.NearByPlacesFragment
import com.ifoursquare.app.presentation.fragments.SearchPlacesFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity()   {

    private var currentSelectedFragment: Fragment? = null

    @Inject
    @Named("getApplicationContext")
    lateinit var contextX: Context

    @Inject
    lateinit var loginModel: LoginModel


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        initDaggerWithModules()

        var binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        initBottomBarViewWithActions(binding)

        addSearchPlacesFragment()
    }

    private fun initDaggerWithModules() {
        val activityComponent =
            (application as IApplication).getApplicationComponent().activityComponent()
        activityComponent.inject(this)
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
        val searchPlacesFragment: SearchPlacesFragment = SearchPlacesFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container, searchPlacesFragment)
            .commit()
        supportFragmentManager.beginTransaction().setPrimaryNavigationFragment(searchPlacesFragment)
        currentSelectedFragment = searchPlacesFragment
    }

    private fun addNearByPlacesFragment() {
        val nearByPlacesFragment: NearByPlacesFragment = NearByPlacesFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.container, nearByPlacesFragment)
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
