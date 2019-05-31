package com.msf.bank.model

import com.google.gson.annotations.SerializedName



class Account {

    @SerializedName("userId")
    private val userId: Int = 0
    @SerializedName("name")
    private val name: String? = null
    @SerializedName("bankAccount")
    private val bankAccount: String? = null
    @SerializedName("agency")
    private val agency: String? = null
    @SerializedName("balance")
    private val balance: Double = 0.toDouble()
}