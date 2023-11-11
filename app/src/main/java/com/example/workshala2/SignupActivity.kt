package com.example.workshala2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.widget.EditText
import android.widget.Toast
import com.example.workshala2.databinding.ActivityMainBinding
import com.example.workshala2.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.log.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }


        title = "Workshala2"
        editText = findViewById(R.id.first)
        val maxTextLength = 20
        editText.filters = arrayOf<InputFilter>(LengthFilter(maxTextLength))

    }
}


