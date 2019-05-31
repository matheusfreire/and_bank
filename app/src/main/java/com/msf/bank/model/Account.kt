package com.msf.bank.model

import com.google.gson.annotations.SerializedName



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
    var balance: Double = 0.toDouble()
}