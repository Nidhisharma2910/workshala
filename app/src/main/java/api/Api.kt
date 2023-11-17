package api


import Models.LoginResponse
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @POST("auth/login/")
    fun userLogin(@Query("email") email: String, @Query("password") password: String): Call<LoginResponse>
}