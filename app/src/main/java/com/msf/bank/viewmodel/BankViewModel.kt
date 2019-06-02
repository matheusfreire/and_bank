package com.msf.bank.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.msf.bank.model.LoginJson
import com.msf.bank.model.StatementJson
import com.msf.bank.repository.ApiService
import com.msf.bank.repository.Calls
import com.msf.bank.util.DaggerInjector
import com.msf.bank.util.Injector
import com.msf.bank.util.RetrofitModule
import javax.inject.Inject

class BankViewModel(application: Application): AndroidViewModel(application) {

    private val injector: Injector = DaggerInjector.builder().networkModule(RetrofitModule).build()

    val mutableLiveData: MutableLiveData<LoginJson> by lazy {
        MutableLiveData<LoginJson>()
    }

    val mutableLiveDataStatements: MutableLiveData<StatementJson> by lazy {
        MutableLiveData<StatementJson>()
    }

    lateinit var loginJson: LoginJson

    init {
        inject()
    }

    private fun inject() {
        injector.inject(this)
    }

    @Inject
    lateinit var apiService: ApiService

    fun callLogin(user: String, password: String) {
        Calls.callLogin(apiService.callLogin(user, password), mutableLiveData)
    }

    fun callStatements() {
        Calls.callStatements(apiService.callStatement(loginJson.account!!.userId),mutableLiveDataStatements)
    }
}