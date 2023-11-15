package com.example.workshala2

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @POST("auth/login/")
    @FormUrlEncoded
    fun getData(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<responseDataClass>
}