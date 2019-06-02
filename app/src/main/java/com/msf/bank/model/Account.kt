package com.msf.bank.model

import com.google.gson.annotations.SerializedName
import com.msf.bank.util.ConvertUtil


class Account {

    @SerializedName("userId")
    var userId: Int = 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("bankAccount")
    var bankAccount: String? = null
    @SerializedName("agency")
    var agency: String? = null
    @SerializedName("balance")
    var balance: Double = 0.0

    fun getCurrencyBalance(): String{
        return ConvertUtil.getCurrencyBalance(balance)
    }

}