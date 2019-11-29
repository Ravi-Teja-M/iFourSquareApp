package com.ifoursquare.app

import com.ifoursquare.app.presentation.di.components.DaggerApplicationComponent
import com.ifoursquare.app.presentation.di.modules.AppContextModule
import com.ifoursquare.app.presentation.di.modules.NetworkingModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class IApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder()
            .appContextModule(AppContextModule(applicationContext))
            .networkingModule(NetworkingModule())
            .build()
    }
}