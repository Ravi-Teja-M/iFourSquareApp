package com.ifoursquare.app.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ifoursquare.app.R
import com.ifoursquare.app.databinding.SignInFragmentBinder
import com.ifoursquare.app.presentation.activities.MainActivity
import com.ifoursquare.app.presentation.viewmodels.LoginViewModel

class SignInFragment : BaseFragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: SignInFragmentBinder

    companion object {
        fun newInstance() = SignInFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_signin_layout, container, false)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.loginViewModel = loginViewModel
        initViewWithActions()
        initMockUserLogin()
        return binding.root
    }

    private fun initMockUserLogin() {
        binding.userNameInputField.setText("raviteja27m@gmail.com")
        binding.passwordInputField.setText("123456")

    }

    private fun initViewWithActions() {
        binding.registerNowBtn.setOnClickListener {

        }
    }

    override fun onResume() {
        super.onResume()
        observeInputFieldData()
        observeSignIn()
    }

    private fun observeSignIn() {
        loginViewModel.loginResultCallback.observe(this, Observer {
            when (it) {
                true -> {
                    activity?.apply {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                else -> {
                    Toast.makeText(
                        activity?.applicationContext,
                        "Sign in failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun observeInputFieldData() {
        loginViewModel.inputValidationResult.observe(this, Observer {

            when (it) {
                LoginViewModel.InputResult.PWD_LENGTH_INVALID -> {
                    binding.passwordInputField.error = "Invalid Action, Password Length"
                }

                LoginViewModel.InputResult.PASSWORD_EMPTY -> {
                    binding.passwordInputField.error = "Invalid Action, Password Empty"
                }

                LoginViewModel.InputResult.USER_NAME_EMPTY -> {
                    binding.userNameInputField.error = "Invalid Action, Username Empty"
                }

                LoginViewModel.InputResult.USER_NAME_FORMAT_INVALID -> {
                    binding.userNameInputField.error = "Invalid Action, Username format invalid"
                }
                else -> {
                    //Warning skip condition
                }
            }
        })
    }
}