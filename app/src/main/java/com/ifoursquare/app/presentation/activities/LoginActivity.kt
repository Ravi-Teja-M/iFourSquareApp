package com.ifoursquare.app.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ifoursquare.app.R
import com.ifoursquare.app.databinding.LoginActivityLayoutBinding
import com.ifoursquare.app.presentation.viewmodels.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: LoginActivityLayoutBinding =
            DataBindingUtil.setContentView(this, R.layout.login_activity_layout)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.loginViewModel = loginViewModel
    }

}
