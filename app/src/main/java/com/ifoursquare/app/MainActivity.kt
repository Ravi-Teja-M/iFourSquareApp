package com.ifoursquare.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifoursquare.app.presentation.fragments.SearchPlacesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        addSearchPlacesFragment()
    }

    private fun addSearchPlacesFragment() {
        val searchPlacesFragment: SearchPlacesFragment = SearchPlacesFragment.newInstance()
        supportFragmentManager.beginTransaction().
            replace(R.id.container,searchPlacesFragment).addToBackStack(null).commit()
    }
}
