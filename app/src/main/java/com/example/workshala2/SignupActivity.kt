package com.example.workshala2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import android.text.Editable
import android.text.TextWatcher
import com.example.workshala2.databinding.ActivityMainBinding
import com.example.workshala2.databinding.ActivitySignupBinding
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding

    lateinit var editText: EditText
    lateinit var editText1: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.log.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.inputEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()) {
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





