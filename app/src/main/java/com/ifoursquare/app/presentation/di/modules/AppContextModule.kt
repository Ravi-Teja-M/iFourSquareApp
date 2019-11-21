package com.ifoursquare.app.presentation.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppContextModule constructor( private val context: Context) {

    @Provides
    @Named("getApplicationContext")
    fun getContext():Context{
        return context
    }
}