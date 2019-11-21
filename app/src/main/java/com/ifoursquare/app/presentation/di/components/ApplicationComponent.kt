package com.ifoursquare.app.presentation.di.components

import com.ifoursquare.app.presentation.activities.MainActivity
import com.ifoursquare.app.presentation.di.modules.AppContextModule
import dagger.Component

@Component(modules = [AppContextModule::class])
interface ApplicationComponent {

    fun inject(context: MainActivity)

}