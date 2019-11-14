package com.ifoursquare.app.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {

    var userNameField: MutableLiveData<String> = MutableLiveData()
    private  set
    var passwordField: MutableLiveData<String> = MutableLiveData()
    private set

    var inputValidationResult: MutableLiveData<Int> = MutableLiveData()
    private set

    companion object {
        val USER_NAME_EMPTY = 0
        val PASSWORD_EMPTY =1
        val USER_NAME_FORMAT_INVALID = 2
        val PWD_LENGTH_INVALID = 3

    }


    fun doLogin(){

    }

    fun validateThenLogin(){
        userNameField.value?.let {
            if(it.trim().isEmpty()){
                inputValidationResult.postValue(USER_NAME_EMPTY)
               return
            }

            
        }

        passwordField.value?.let {
            if(it.trim().isEmpty()){
                inputValidationResult.postValue(PASSWORD_EMPTY)
                return
            }
        }


    }
}

