package com.ifoursquare.app.presentation.di.components

import com.ifoursquare.app.presentation.activities.MainActivity
import com.ifoursquare.app.presentation.di.modules.AppContextModule
import com.ifoursquare.app.presentation.di.modules.NetworkingModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton

@Component(   modules = [AppContextModule::class, NetworkingModule::class ])
interface ApplicationComponent {

    fun inject(context: MainActivity)

  //  fun getRetrofit(): Retrofit

}