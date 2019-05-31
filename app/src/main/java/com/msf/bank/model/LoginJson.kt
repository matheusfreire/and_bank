package com.msf.bank.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginJson {

    @SerializedName("userAccount")
    @Expose
    var account: Account? = null
    @SerializedName("error")
    @Expose
    var error: Error? = null

}