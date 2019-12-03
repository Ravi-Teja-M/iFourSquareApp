package com.ifoursquare.app.presentation.activities

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.ifoursquare.app.R
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

        val animator = ObjectAnimator.ofFloat(imageView,"translationY", -900f).apply {
            duration = 500
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
