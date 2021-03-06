package com.msf.bank.repository

import com.msf.bank.model.LoginJson
import com.msf.bank.model.StatementJson
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun callLogin(@Field("user") username: String, @Field("password") password: String): Call<LoginJson>

    @GET("statements/{id}")
    fun callStatement(@Path("id") idUser: Int): Call<StatementJson>

}