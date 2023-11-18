package com.example.workshala2


import Models.LoginReq
import Models.LoginRes
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import api.RetrofitClient
import com.example.workshala2.databinding.ActivitySigninBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            
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

            try {
                RetrofitClient.retrofit.userLogin(LoginReq(email, password))
                    .enqueue(object : Callback<LoginRes> {
                        override fun onResponse(
                            call: Call<LoginRes>,
                            response: Response<LoginRes>
                        ) {
                            Log.d("nidhi", response.code().toString())
                            Log.d("nidhi", response.body().toString())
                        }

                        override fun onFailure(call: Call<LoginRes>, t: Throwable) {
                            Log.d("nidhi", "failure")
                        }
                    })
            } catch (e: Exception) {
                Log.e("nidhi", "Something is wrong")
            }
        }

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