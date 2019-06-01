package com.msf.bank.model

import com.google.gson.annotations.SerializedName
import java.text.NumberFormat
import java.util.*


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
        val format = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        return format.format(balance)
    }

}