package com.ifoursquare.app.presentation.di.components

import com.ifoursquare.app.IApplication
import com.ifoursquare.app.presentation.activities.MainActivity
import com.ifoursquare.app.presentation.di.modules.ActivityModule
import com.ifoursquare.app.presentation.di.modules.AppContextModule
import com.ifoursquare.app.presentation.di.modules.NetworkingModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton

@Component(   modules = [ AndroidSupportInjectionModule::class, AppContextModule::class, NetworkingModule::class , ActivityModule::class])
interface ApplicationComponent : AndroidInjector<IApplication>