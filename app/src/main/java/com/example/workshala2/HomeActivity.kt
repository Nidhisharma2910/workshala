package com.example.workshala2

import Models.ProfileRes
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import api.RetrofitClient
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class HomeActivity : AppCompatActivity() {

    private lateinit var textView34: TextView
    private lateinit var bottomNavigationView: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        bottomNavigationView = findViewById(R.id.bottomNavigationView2)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val handled = when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(home_page_p())
                    true
                }
                R.id.courses -> {
                  Toast.makeText(this, "already in homepage", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.job -> {
                    replaceFragment(job_page_p())
                    true
                }
                R.id.profile -> {
                    replaceFragment(profile_page_p())
                    true
                }
                else -> false
            }
            handled

        }


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

    private fun  replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}
