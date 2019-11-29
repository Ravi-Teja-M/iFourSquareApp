package com.ifoursquare.app

import android.app.Application
import com.ifoursquare.app.presentation.di.components.ApplicationComponent
import com.ifoursquare.app.presentation.di.components.DaggerApplicationComponent
import com.ifoursquare.app.presentation.di.modules.AppContextModule
import com.ifoursquare.app.presentation.di.modules.NetworkingModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class IApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjectorInstance: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjectorInstance

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent.builder().
            appContextModule(AppContextModule(applicationContext))
            .networkingModule(NetworkingModule())
            .build().inject(this)


    }

}