package com.ifoursquare.app.presentation.di.modules

import com.ifoursquare.app.presentation.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

  @ContributesAndroidInjector(modules = [FragmentModule::class])

  abstract fun mainActivity(): MainActivity

}