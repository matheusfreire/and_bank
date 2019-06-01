package com.msf.bank.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.msf.bank.BuildConfig
import com.msf.bank.repository.ApiService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object RetrofitModule {


    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder().baseUrl(BuildConfig.API_ROOT)
            .addConverterFactory(GsonConverterFactory.create(createGson()))
            .build()
    }

    private fun createGson(): Gson {
        return GsonBuilder().setDateFormat(Constants.PATTERN_DATE_CONVERT).create()
    }

}