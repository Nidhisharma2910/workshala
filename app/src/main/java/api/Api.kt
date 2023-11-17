package api


import Models.LoginReq
import Models.LoginReq1
import Models.LoginRes
import Models.LoginRes1
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("auth/login/")
    fun userLogin(@Body loginReq: LoginReq): Call<LoginRes>

    @POST("auth/register")
    fun userLogin1(@Body loginReq: LoginReq1): Call<LoginRes1>
}