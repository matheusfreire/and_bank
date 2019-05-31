package com.msf.bank.repository

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.msf.bank.BuildConfig
import com.msf.bank.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
object RetrofitInstance {


    @Provides
    @Singleton
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.API_ROOT)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .build()
    }

    private fun createGson(): Gson {
        return GsonBuilder().setDateFormat(Constants.PATTERN_DATE_CONVERT).create()
    }

}