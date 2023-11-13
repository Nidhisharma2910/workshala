package com.example.workshala2


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivitySigninBinding
import com.google.android.material.textfield.TextInputLayout
import java.util.logging.Logger
import java.util.regex.Pattern

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
        binding.textInputEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(binding.textInputEmail.text.toString()).matches())
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