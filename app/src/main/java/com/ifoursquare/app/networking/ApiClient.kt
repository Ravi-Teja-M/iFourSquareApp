package com.ifoursquare.app.networking

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private lateinit var apiClient: ApiClient

    object RetroInstance {
        private lateinit var retrofit: Retrofit
        private lateinit var okHttpClient: OkHttpClient


        fun get() = getRetrofitInstance()

        private fun getRetrofitInstance(): Retrofit {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    //.addCallAdapterFactory()  RxJava Bindings
                    .addConverterFactory(GsonConverterFactory.create(Gson()))
                    .baseUrl(ServiceConstants.BASE_URL)
                    .client(getOkHTTPClient())
                    .build()
            }
            return retrofit
        }

        private fun getOkHTTPClient(): OkHttpClient {
            if (okHttpClient == null) {
                okHttpClient = OkHttpClient.Builder()
                    //.addInterceptor()
                    .readTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()
            }
            return okHttpClient
        }
    }


}