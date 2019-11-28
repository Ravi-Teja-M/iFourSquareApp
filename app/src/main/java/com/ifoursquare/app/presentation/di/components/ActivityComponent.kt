package com.ifoursquare.app.presentation.di.components

import com.ifoursquare.app.presentation.activities.MainActivity
import com.ifoursquare.app.presentation.di.modules.ActivityModule
import dagger.Subcomponent

@Subcomponent(modules =[ActivityModule::class] )
interface ActivityComponent {

   fun  inject(context: MainActivity)
}