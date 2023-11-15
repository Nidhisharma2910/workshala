package com.example.workshala2

import retrofit2.http.GET

interface ApiInterface {
    @GET("auth/login/")
    fun getData()
}