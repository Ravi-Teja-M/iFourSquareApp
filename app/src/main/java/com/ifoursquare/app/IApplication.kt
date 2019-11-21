package com.ifoursquare.app

import android.app.Application
import com.ifoursquare.app.presentation.di.components.ApplicationComponent
import com.ifoursquare.app.presentation.di.components.DaggerApplicationComponent
import com.ifoursquare.app.presentation.di.modules.AppContextModule

class IApplication : Application( ) {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .appContextModule(AppContextModule(this))
            .build()
    }

    fun getApplicationComponent() : ApplicationComponent{
        return applicationComponent
    }

}