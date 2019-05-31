package com.msf.bank.repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.msf.bank.BuildConfig
import com.msf.bank.util.Constants
import dagger.Module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import dagger.Provides


@Module
class RetrofitInstance {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BuildConfig.API_ROOT)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build()
    }
    @Provides
    fun provideNetworkApi(): RetrofitInstance {
        return RetrofitInstance()
    }

    private fun createGson(): Gson {
        return GsonBuilder().setDateFormat(Constants.PATTERN_DATE_CONVERT).create()
    }

    fun getApiService():ApiService{
        return retrofit.create(ApiService::class.java)
    }
}