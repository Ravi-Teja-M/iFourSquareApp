package com.ifoursquare.app.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.ifoursquare.app.presentation.utils.Logger

class LoginViewModel : ViewModel() {

    var userNameField: MutableLiveData<String> = MutableLiveData("raviteja27m@gmail.com")
    var passwordField: MutableLiveData<String> = MutableLiveData("123456")

    var inputValidationResult: MutableLiveData<InputResult> = MutableLiveData()
        private set

    var loginResultCallback: MutableLiveData<Boolean> = MutableLiveData()
        private set

    enum class InputResult {
        USER_NAME_EMPTY,
        PASSWORD_EMPTY,
        USER_NAME_FORMAT_INVALID,
        PWD_LENGTH_INVALID
    }

    fun doLogin() {
        if (onInputValidation()) {
            initFireBaseAuthLogin()
        }
    }

    private fun initFireBaseAuthLogin() {
        //Strict not null after validation
        FirebaseAuth.getInstance()
            .signInWithEmailAndPassword(userNameField.value!!, passwordField.value!!)
            .addOnSuccessListener {
                it?.let {
                    Logger(it.user?.displayName)
                    loginResultCallback.postValue(true)
                }
            }
            .addOnCanceledListener {

            }
            .addOnFailureListener {
                loginResultCallback.postValue(false)
            }
    }

    private fun onInputValidation(): Boolean {
        userNameField.value?.let {
            if (it.trim().isEmpty()) {
                inputValidationResult.postValue(InputResult.USER_NAME_EMPTY)
                return false
            }
        }

        passwordField.value?.let {

            if (it.trim().isEmpty()) {
                inputValidationResult.postValue(InputResult.PASSWORD_EMPTY)
                return false
            }

            if (it.trim().length < 4) {
                inputValidationResult.postValue(InputResult.PWD_LENGTH_INVALID)
                return false
            }
        }
        return true
    }
}

