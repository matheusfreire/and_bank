package com.msf.bank.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.msf.bank.util.ConvertUtil

class Statement {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("desc")
    @Expose
    var desc: String? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("value")
    @Expose
    var value: Double? = null

    fun getCurrencyValue(): String{
        return ConvertUtil.getCurrencyBalance(value!!)
    }

    fun getFormattedDate():String{
        return ConvertUtil.getDateFormatted(date!!)
    }
}