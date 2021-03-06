package com.msf.bank.repository

import androidx.lifecycle.MutableLiveData
import com.msf.bank.model.LoginJson
import com.msf.bank.model.StatementJson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object Calls {

    fun callLogin(loginCall: Call<LoginJson>,mutableLiveData: MutableLiveData<LoginJson>){
        loginCall.enqueue(object : Callback<LoginJson> {
            override fun onFailure(call: Call<LoginJson>, t: Throwable) {
                mutableLiveData.postValue(null)
            }

            override fun onResponse(call: Call<LoginJson>, response: Response<LoginJson>) {
                mutableLiveData.postValue(response.body())
            }
        })
    }

    fun callStatements(callStatement: Call<StatementJson>, mutableLiveDataStatements: MutableLiveData<StatementJson>) {
        callStatement.enqueue(object : Callback<StatementJson> {
            override fun onFailure(call: Call<StatementJson>, t: Throwable) {
                mutableLiveDataStatements.postValue(null)
            }

            override fun onResponse(call: Call<StatementJson>, response: Response<StatementJson>) {
                mutableLiveDataStatements.postValue(response.body())
            }
        })
    }
}