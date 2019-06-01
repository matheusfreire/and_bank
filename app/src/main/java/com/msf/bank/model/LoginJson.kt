package com.msf.bank.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginJson() : Parcelable{

    @SerializedName("userAccount")
    @Expose
    var account: Account? = null
    @SerializedName("error")
    @Expose
    var error: Error? = null

    constructor(parcel: Parcel) : this() {

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginJson> {
        override fun createFromParcel(parcel: Parcel): LoginJson {
            return LoginJson(parcel)
        }

        override fun newArray(size: Int): Array<LoginJson?> {
            return arrayOfNulls(size)
        }
    }

}