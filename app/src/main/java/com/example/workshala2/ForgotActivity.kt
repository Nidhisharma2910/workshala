package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityForgotBinding
import com.example.workshala2.databinding.ActivitySignupBinding

class ForgotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.emailErrorText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
                    binding.button3.isEnabled = true
                    binding.emailErrorText.error = null // Clear any previous error
                } else {
                    binding.button3.isEnabled = false
                    binding.emailErrorText.error = "Invalid Email"
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

    }
}