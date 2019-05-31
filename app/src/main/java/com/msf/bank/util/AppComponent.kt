package com.msf.bank.util

import dagger.Component
import javax.inject.Singleton
import com.msf.bank.view.MainActivity



@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}