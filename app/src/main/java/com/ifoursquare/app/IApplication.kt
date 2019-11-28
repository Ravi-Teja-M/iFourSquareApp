package com.ifoursquare.app

import android.app.Activity
import android.app.Application
import com.ifoursquare.app.presentation.di.components.ApplicationComponent
import com.ifoursquare.app.presentation.di.components.DaggerApplicationComponent
import com.ifoursquare.app.presentation.di.modules.AppContextModule
import com.ifoursquare.app.presentation.di.modules.NetworkingModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class IApplication : Application( ), HasAndroidInjector{

    @Inject
    lateinit var androidInjectorInstance : DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any>  = androidInjectorInstance

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .appContextModule(AppContextModule(this))
            .networkingModule(NetworkingModule())
            .build()
        applicationComponent.inject(this)
    }

    fun getApplicationComponent() : ApplicationComponent{
        return applicationComponent
    }

}