package com.msf.bank.repository

import com.msf.bank.model.StatementJson
import com.msf.bank.model.LoginJson
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @FormUrlEncoded
    @POST("login")
    fun callLogin(@Field("user") username: String, @Field("password") password: String): Call<LoginJson>

    @GET("statements/{id}")
    fun callStatement(@Path("id") idMovie: Int): Call<StatementJson>
}