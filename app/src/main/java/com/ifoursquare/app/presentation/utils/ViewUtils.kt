package com.ifoursquare.app.presentation.utils

import android.util.Log.v
import com.ifoursquare.app.BuildConfig

fun Logger(input: String?) {
    if (BuildConfig.DEBUG) {
        input?.let {
            v("iFourSquare", " >  $input  >")
        }
    }
}