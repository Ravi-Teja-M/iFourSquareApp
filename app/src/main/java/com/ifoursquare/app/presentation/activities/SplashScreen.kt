package com.ifoursquare.app.presentation.activities

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Path
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ifoursquare.app.R
import com.ifoursquare.app.presentation.utils.getLocationOnScreen
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SplashScreen : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job: Job = Job()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        }

    override fun onStart() {
        super.onStart()
        val imageView = findViewById<ImageView>(R.id.app_logo_splash)
        val titleLabel: TextView = findViewById(R.id.textView)

        val animator = ObjectAnimator.ofFloat(imageView,"translationY", -900f).apply {
            duration = 1500
            start()
        }
        animator.addListener(object :Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                initUserAuthentication()
            }

            override fun onAnimationStart(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }
        })
    }

     private fun initUserAuthentication() {
        val auth: FirebaseAuth = FirebaseAuth.getInstance()
        launch {
            delay(100)
            withContext(Dispatchers.Main) {
                //auth logic
                if (auth.currentUser == null) {
                    loginScreenIntent()
                } else {
                    dashboardScreenIntent()
                }
            }
        }
    }

    private fun dashboardScreenIntent() {
        val intent = Intent(this@SplashScreen, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun loginScreenIntent() {
        val intent = Intent(this@SplashScreen, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onPause() {
        super.onPause()
        if (job.isActive) {
            job.cancel()
        }
    }
}
