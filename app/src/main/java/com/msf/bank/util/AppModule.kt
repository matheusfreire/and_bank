package com.msf.bank.util

import android.app.Application
import dagger.Component
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

@Module
class AppModule(var mApplication: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return mApplication
    }
}