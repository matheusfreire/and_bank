package com.msf.bank.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class StatementJson {

    @SerializedName("statementList")
    @Expose
    var statementList: List<Statement>? = null
    @SerializedName("error")
    @Expose
    var error: Error? = null

}