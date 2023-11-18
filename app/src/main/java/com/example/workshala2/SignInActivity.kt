package com.example.workshala2

// Base URL: workshala-api.onrender.com/
import Models.LoginResponse
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import api.RetrofitClient
import com.example.workshala2.databinding.ActivitySigninBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forgot.setOnClickListener {
            val intent = Intent(this, ForgotActivity::class.java)
            startActivity(intent)

        }

        val button2 = binding.button2
        val editTextEmail = binding.textInputEmail
        val editTextPassword = binding.password



        button2.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (email.isEmpty()) {
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.retrofit.userLogin(email, password)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.e("LoginActivity", "Login request failed", t)
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        if (!response.isSuccessful) {
                            Log.e(
                                "LoginActivity",
                                "Login request unsuccessful. HTTP code: ${response.code()}"
                            )
                            Toast.makeText(
                                applicationContext,
                                "Login request unsuccessful",
                                Toast.LENGTH_LONG
                            ).show()
                            return
                        }

                        val loginResponse = response.body()

                        if (loginResponse?.error == false) {
                            Log.d("LoginActivity", "Login successful. User: ${loginResponse.user}")



                        } else {
                            Log.w(
                                "LoginActivity",
                                "Login request successful, but server returned an error. Message: ${loginResponse?.message}"
                            )
                            Toast.makeText(
                                applicationContext,
                                loginResponse?.message,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                })
        }

//            RetrofitClient.instance.userLogin(email, password)
//
//                .enqueue(object: Callback<LoginResponse>{
//                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                        Log.e("LoginActivity", "Login request failed", t)
//                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
//                    }
//
//
//
//                    override fun onResponse(
//                        call: Call<LoginResponse>,
//                        response: Response<LoginResponse>
//                    ) {
//                        if(!response.body()?.error!!){
//
//                            SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.user!!)
//
//                            val intent = Intent(applicationContext, JobActivity::class.java)
//                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//
//                            startActivity(intent)
//
//
//                        }else{
//                            Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
//                        }
//                    }
//                    })
//
//
//                }
            binding.textInputEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (Patterns.EMAIL_ADDRESS.matcher(binding.textInputEmail.text.toString()).matches())
                    binding.button2.isEnabled = true
                else {
                    binding.button2.isEnabled = false
                    binding.textInputEmail.error = "Invalid Email"
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
    }



}