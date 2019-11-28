package com.ifoursquare.app.presentation.di.components

import com.ifoursquare.app.IApplication
import com.ifoursquare.app.presentation.activities.MainActivity
import com.ifoursquare.app.presentation.di.modules.AppContextModule
import com.ifoursquare.app.presentation.di.modules.NetworkingModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton

@Component(   modules = [ AndroidSupportInjectionModule::class, AppContextModule::class, NetworkingModule::class ])
interface ApplicationComponent {

    fun inject(context: IApplication)

    fun activityComponent():  ActivityComponent

}