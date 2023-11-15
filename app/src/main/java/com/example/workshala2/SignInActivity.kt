package com.example.workshala2

// Base URL: workshala-api.onrender.com/
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

        val apiService = RetrofitInstance.retrofit.create(ApiInterface::class.java)

        val username = findViewById<EditText>(R.id.text_input_email).text.toString()
        val password = findViewById<EditText>(R.id.password).text.toString()

        val call = apiService.getData(username, password)

        call.enqueue(object : Callback<responseDataClass> {
            override fun onResponse(call: Call<responseDataClass>, response: Response<responseDataClass>) {
                if (response.isSuccessful) {
                    // Handle the successful login response
                    val responseData = response.body()
                    // Update UI or perform further actions
                    Log.d("SignInActivity", "Login successful. Response data: $responseData")
                } else {
                    // Handle the error response
                    // Display an error message or take appropriate action
                    Log.e("SignInActivity", "Login failed. Response code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<responseDataClass>, t: Throwable) {
                // Handle the network failure
                // Display an error message or take appropriate action
                Log.e("SignInActivity", "Network request failed. Error: ${t.localizedMessage}")
                Toast.makeText(this@SignInActivity, "${t.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
        })


//        getData()
//
//        binding.button2.setOnClickListener(){
//            getData()
//        }
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

//    private fun getData() {
//
//        val progressDialog = ProgressDialog(this)
//        progressDialog.setMessage("Please wait while data is fetch")
//        progressDialog.show()
//
//        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responseDataClass?> {
//            override fun onResponse(
//                call: Call<responseDataClass?>,
//                response: Response<responseDataClass?>
//            ) {
//                binding.textInputEmail.text= response.body()?.properties
//                progressDialog.dismiss( )
//            }
//
//            override fun onFailure(call: Call<responseDataClass?>, t: Throwable) {
//                Toast.makeText(this@SignInActivity,"${t.localizedMessage}",Toast.LENGTH_SHORT)
//                    .show()
//                progressDialog.dismiss()
//            }
//        })
//
//    }

}