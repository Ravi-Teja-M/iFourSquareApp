package com.ifoursquare.app.data.model.login

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class LoginModel( userName: String ="",    password: String="" ) : BaseObservable( ) {


     var userName: String = userName
         @Bindable get() =  field
    set(value) {
        field= value
        notifyPropertyChanged(BR.userName)
     }

      var password: String = password
        @Bindable get() =  field
        set(value) {
            field= value
            notifyPropertyChanged(BR.password)
        }

}