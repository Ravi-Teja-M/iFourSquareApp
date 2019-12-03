package com.ifoursquare.app.presentation.di.modules

import com.ifoursquare.app.presentation.fragments.SignInFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {

    @ContributesAndroidInjector
    abstract fun loginFragment():SignInFragment
}