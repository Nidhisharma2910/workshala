package com.example.workshala2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://workshala-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val apiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }


}