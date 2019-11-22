package com.ifoursquare.app.presentation.di.modules

import com.google.gson.Gson
import com.ifoursquare.app.networking.ServiceConstants
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkingModule  {

    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient , gsonConverterFactory: GsonConverterFactory):Retrofit {
        return Retrofit.Builder()
            //.addCallAdapterFactory() // RxJava Bindings
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(ServiceConstants.BASE_URL)
            .client(okHttpClient)
            .build()
     }

    @Provides
    @Singleton
    fun getOkHttpClient(interceptor:Interceptor):OkHttpClient {
          return  OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun gsonConvertor( ): GsonConverterFactory{
        return GsonConverterFactory.create(Gson())
    }

    @Provides
    @Singleton
    fun interceptor(): Interceptor  = Interceptor {
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

