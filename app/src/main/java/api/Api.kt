package api


import Models.LoginReq
import Models.LoginReq1
import Models.LoginRes
import Models.LoginRes1
import Models.ProfileRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("auth/login/")
    fun userLogin(@Body loginReq: LoginReq): Call<LoginRes>

    @POST("auth/register/")
    fun userLogin1(@Body loginReq1: LoginReq1): Call<LoginRes1>

    @GET("auth/profiles/")
    fun getProfile(): Call<ProfileRes>
}