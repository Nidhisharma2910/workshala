package com.example.workshala2

import Models.ProfileRes
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import api.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class HomeActivity : AppCompatActivity() {

    private lateinit var textView34: TextView 

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        textView34 = findViewById(R.id.text35) // Initialize your TextView here

        try {
            RetrofitClient.retrofit.getProfile()
                .enqueue(object : Callback<ProfileRes> {
                    override fun onResponse(call: Call<ProfileRes>, response: Response<ProfileRes>) {
                        if (response.isSuccessful) {
                            val profile: ProfileRes? = response.body()
                            if (profile != null) {
                                // Update your TextViews with the data from the API response
                                textView34.text = "Hello, ${profile?.fullname}"
                                // You can similarly update other TextViews based on your API response
                            }
                        } else {
                            Log.d("nidhi", response.code().toString())
                            Log.d("nidhi", response.body().toString())
                            // Handle error
                            // You can check response.code(), response.errorBody(), etc. for more details
                        }
                    }

                    override fun onFailure(call: Call<ProfileRes>, t: Throwable) {
                        // Handle failure
                        if (t is IOException) {
                            // Handle network-related errors
                            Log.d("nidhi", "network error")
                        } else {
                            // Handle other errors
                            Log.d("nidhi", "failure",t)
                        }
                    }
                })
        } catch (e: Exception) {
            // Handle other exceptions
            Log.e("nidhi", "Something is wrong")
        }

        val job = findViewById<TextView>(R.id.textView41)
        job.setOnClickListener {
            val intent = Intent(this, JobActivity::class.java)
            startActivity(intent)
        }

        val aboutDoc = findViewById<TextView>(R.id.textView38)
        aboutDoc.setOnClickListener {
            val intent = Intent(this, AndroidLargeActivity::class.java)
            startActivity(intent)
        }
    }
}
