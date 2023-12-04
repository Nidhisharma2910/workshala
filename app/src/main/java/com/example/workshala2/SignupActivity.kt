package com.example.workshala2

import Models.LoginReq1
import Models.LoginRes1
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import api.RetrofitClient
import com.example.workshala2.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    lateinit var editText: EditText
    lateinit var editText1: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button1 = binding.button
        val inputEmail = binding.inputEmail
        val passwordEditText1 = binding.passwordEditText
        val username1 = binding.first



        button1.setOnClickListener {
            val passwordEditText: EditText = findViewById(R.id.passwordEditText)
            val confirmPasswordEditText: EditText = findViewById(R.id.confirmPasswordEditText)

            val password1 = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (password1 != confirmPassword) {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.error_confirm_password_title))
                    .setMessage(getString(R.string.error_confirm_password_msg))
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setCancelable(false)
                    .show()
            }



            val email = inputEmail.text.toString().trim()
            val username = username1.text.toString().trim()
            val password = passwordEditText1.text.toString().trim()



            if(email.isEmpty()) {
                inputEmail.error = "Email required"
                inputEmail.requestFocus()
                return@setOnClickListener
            }
            if(username.isEmpty()) {
                username1.error = "First Name required"
                username1.requestFocus()
                return@setOnClickListener
            }
            if(password.isEmpty()) {
                passwordEditText1.error = "Password required"
                passwordEditText1.requestFocus()
                return@setOnClickListener
            }

            try {
                RetrofitClient.retrofit.userLogin1(LoginReq1(email, username, password))
                    .enqueue(object :Callback<LoginRes1>{
                        override fun onResponse(
                            call: Call<LoginRes1>,
                            response: Response<LoginRes1>
                        ) {
                            Log.d("nidhi", response.code().toString())
                            Log.d("nidhi", response.body().toString())
                        }

                        override fun onFailure(call: Call<LoginRes1>, t: Throwable) {
                            Log.d("nidhi", "failed")
                        }
                    })
            } catch (e:Exception){
                Log.e("nidhi", "something is wrong")
            }

        }


        binding.log.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.inputEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                    binding.button.isEnabled = true
                    binding.inputEmail.error = null // Clear any previous error
                } else {
                    binding.button.isEnabled = false
                    binding.inputEmail.error = "Invalid Email"
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        title = "Workshala2"
        editText = findViewById(R.id.first)
        val maxTextLength = 20
        editText.filters = arrayOf<InputFilter>(LengthFilter(maxTextLength))

        title = "Workshala2"
        editText1 = findViewById(R.id.last)
        val maxTextLength1 = 20
        editText1.filters = arrayOf<InputFilter>(LengthFilter(maxTextLength1))

    }


}