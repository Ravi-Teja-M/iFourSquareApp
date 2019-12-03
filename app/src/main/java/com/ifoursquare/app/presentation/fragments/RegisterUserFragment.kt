package com.ifoursquare.app.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ifoursquare.app.R
import com.ifoursquare.app.databinding.FragmentRegisterUserScreenBinding

class RegisterUserFragment : BaseFragment() {

    private lateinit var registerUserScreenBinding: FragmentRegisterUserScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        registerUserScreenBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_register_user_screen,
            container,
            false
        )

        return registerUserScreenBinding.root
    }
}