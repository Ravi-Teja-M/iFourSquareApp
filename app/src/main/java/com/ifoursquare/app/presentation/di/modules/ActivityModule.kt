package com.ifoursquare.app.presentation.di.modules

import com.ifoursquare.app.data.model.login.LoginModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {


    @Provides
    fun loginModelMock():LoginModel {

        return  LoginModel("Rav","Tej")
    }


}