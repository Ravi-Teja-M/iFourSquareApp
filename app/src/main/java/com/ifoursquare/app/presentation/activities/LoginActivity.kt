package com.ifoursquare.app.presentation.activities

import android.os.Bundle
import com.ifoursquare.app.R
import com.ifoursquare.app.presentation.fragments.SignInFragment

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity_layout)
        val loginFragment = SignInFragment.newInstance()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, loginFragment)
            .commit()
    }
}
