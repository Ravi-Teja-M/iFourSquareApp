package com.ifoursquare.app.networking

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {


    object RetroInstance {


        fun get() = getRetrofitInstance()

        private fun getRetrofitInstance(): Retrofit {

             var retrofit: Retrofit
                     = Retrofit.Builder()
                    //.addCallAdapterFactory() // RxJava Bindings
                    .addConverterFactory(GsonConverterFactory.create(Gson()))
                    .baseUrl(ServiceConstants.BASE_URL)
                    .client(getOkHTTPClient())
                    .build()

            return retrofit
        }

        private fun getOkHTTPClient(): OkHttpClient {
            var okHttpClient: OkHttpClient

                 = OkHttpClient.Builder()
                    .addInterceptor(interceptor())
                    .readTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()

            return okHttpClient
        }

        private fun interceptor(): Interceptor  = Interceptor {

                chain: Interceptor.Chain ->

            val original = chain.request()
            val httUrl = original.url()

            val httpUrlBuilder = httUrl.newBuilder()
                .addQueryParameter("client_id",ServiceConstants.CLIENT_ID)
                .addQueryParameter("client_secret",ServiceConstants.CLIENT_SECRET)
                .addQueryParameter("v","20171122")
                .build()

            val request = original.newBuilder().url(httpUrlBuilder).build()
            chain.proceed(request)
        }
    }
}