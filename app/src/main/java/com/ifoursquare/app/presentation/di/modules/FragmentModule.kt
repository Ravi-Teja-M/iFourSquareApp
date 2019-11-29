package com.ifoursquare.app.presentation.di.modules

import com.ifoursquare.app.presentation.fragments.SearchPlacesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule{

   @ContributesAndroidInjector
   abstract  fun fragmentSearchPlaces():SearchPlacesFragment
}