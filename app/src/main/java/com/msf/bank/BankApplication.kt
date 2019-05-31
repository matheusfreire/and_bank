package com.msf.bank

import android.app.Application
import com.msf.bank.util.AppComponent
import com.msf.bank.util.AppModule
import com.msf.bank.util.DaggerAppComponent
import com.msf.bank.util.RetrofitModule

class BankApplication:Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule( AppModule(this)).retrofitModule(RetrofitModule()).build()
    }

    fun getAppComponent():AppComponent{
        return appComponent
    }
}