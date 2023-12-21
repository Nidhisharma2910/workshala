package com.example.workshala2

import Models.ProfileRes
import Models.RecommendedCourse
import Models.User
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.userProfileChangeRequest
import androidx.fragment.app.Fragment
import api.ApiClient
import api.RecommendedCourseApiService
import api.RetrofitClient
import com.example.workshala2.databinding.ActivityHomepageBinding
import com.example.workshala2.databinding.ActivitySignupBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding
    private lateinit var textView34: TextView
    private lateinit var bottomNavigationView: BottomNavigationView

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_homepage)



// Now 'displayName' holds the user's first name, and you can use it as needed


//        // Get the current user
//        val user = Firebase.auth.currentUser
//
//// Update the user's display name
//        val profileUpdates = userProfileChangeRequest {
//            displayName = "New Display Name"
//        }
//
//        user?.updateProfile(profileUpdates)?.addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                // Display name updated successfully
//                Log.d("Firebase", "User profile updated.")
//
//                // You may want to notify the user or update UI accordingly
//            } else {
//                // If updating fails, log the error
//                Log.e("Firebase", "Failed to update user profile.", task.exception)
//
//                // Handle the error or notify the user
//            }
//        }
//
//        user?.reload()?.addOnCompleteListener { reloadTask ->
//            if (reloadTask.isSuccessful) {
//                // Now access updated user information, including displayName
//                val updatedUser = Firebase.auth.currentUser
//                Log.d("Firebase", "User reloaded successfully.")
//                // Update your UI or handle the updated user information
//            } else {
//                // Handle the reload failure
//                Log.e("Firebase", "Failed to reload user.", reloadTask.exception)
//            }
//        }
//


        val user = Firebase.auth.currentUser
        user?.let {
            // Access the display name
            val displayName = it.displayName

            // Split the full name into first and last names
            val names = displayName?.split(" ")

            // Now names[0] should contain the first name
            val firstname = names?.get(0)

            // Log the first name for testing
            Log.d("ProfileActivity", "User First Name: $firstname")

            // Now, you can use the firstName in your UI or wherever you need it
        }




//        Firebase.database.reference.child("Users").child(Firebase.auth.currentUser!!.uid)
//            .addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    Log.d("Firebase", "onDataChange called")
//                    var user = snapshot.getValue<User>()
//                    Log.d("Firebase", "Snapshot exists")
//
//
//                    binding.text35.text = user?.firstname
//                    Log.d("Firebase", "User data retrieved: $user")
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    Log.e("Firebase", "Data retrieval cancelled: ${error.message}")
//                }
//            })



//    val apiService = ApiClient.retrofit.create(RecommendedCourseApiService::class.java)
//
//    val call: Call<List<RecommendedCourse>> = apiService.getRecommendedCourses()
//
//    call.enqueue(object : Callback<List<RecommendedCourse>> {
//        override fun onResponse(
//            call: Call<List<RecommendedCourse>>,
//            response: Response<List<RecommendedCourse>>
//        ) {
//            if (response.isSuccessful) {
//                val recommendedCourses: List<RecommendedCourse>? = response.body()
//                // Process recommendedCourses here
//
//                if (recommendedCourses != null) {
//                    // Process recommendedCourses here
//                    for (course in recommendedCourses) {
//                        // Do something with each course
//                        println("Course Name: ${course.courseName}")
//                        println("Course Id: ${course.courseId}")
//                        // Add more fields as needed
//                    }
//                } else {
//
//                }
//
//            } else {
//                // Handle error
//                println("API request failed with status code: ${response.code()}")
//            }
//        }
//
//        override fun onFailure(call: Call<List<RecommendedCourse>>, t: Throwable) {
//            // Handle failure
//        }
//    })
//

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


//        textView34 = findViewById(R.id.text35) // Initialize your TextView here
//
//        try {
//            val loguser = intent.getStringExtra("loggeduser")
//            if (loguser != null) {
//                RetrofitClient.retrofit.getProfile(loguser)
//                    .enqueue(object : Callback<ProfileRes> {
//                        override fun onResponse(call: Call<ProfileRes>, response: Response<ProfileRes>) {
//                            if (response.isSuccessful) {
//                                val profile: ProfileRes? = response.body()
//                                if (profile != null) {
//
//                                    // Update your TextViews with the data from the API response
//                                    textView34.text = "Hello, ${profile?.fullname}"
//                                    // You can similarly update other TextViews based on your API response
//                                }
//                            } else {
//                                Log.d("nidhi", response.code().toString())
//                                Log.d("nidhi", response.body().toString())
//                                // Handle error
//                                // You can check response.code(), response.errorBody(), etc. for more details
//                            }
//                        }
//
//
//                        override fun onFailure(call: Call<ProfileRes>, t: Throwable) {
//                            TODO("Not yet implemented")
//                        }
//
//
//                    })
//            }
//        } catch (e: Exception) {
//            // Handle other exceptions
//            Log.e("nidhi", "Something is wrong")
//        }

        val job = findViewById<TextView>(R.id.textView41)
        job.setOnClickListener {
            val intent = Intent(this, JobActivity::class.java)
            startActivity(intent)
        }

        val filter = findViewById<ImageView>(R.id.imageView21)
        filter.setOnClickListener {
            val intent = Intent(this, FilterTwoActivity::class.java)
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
