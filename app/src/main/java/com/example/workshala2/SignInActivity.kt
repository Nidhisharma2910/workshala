package com.example.workshala2


import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivitySigninBinding
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class SignInActivity : AppCompatActivity() {

    private val PASSWORD_PATTERN: Pattern = Pattern.compile(
        "^(?=.*[a-zA-Z])" +
                "(?=.*[@#$%^&+=])" +
                "(?=\\S+$)" +
                ".{4,}" +
                "$"
    )
    private lateinit var textInputEmail: TextInputLayout
    private lateinit var textInputPassword: TextInputLayout
    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.forgot.setOnClickListener {
            val intent = Intent(this, ForgotActivity::class.java)
            startActivity(intent)

            textInputEmail = findViewById(R.id.text_input_email)
            textInputPassword = findViewById(R.id.text_input_password)
        }
    }
    private fun validateEmail(): Boolean {
        val emailInput = textInputEmail.editText?.text.toString().trim()
        return if (emailInput.isEmpty()) {
            textInputEmail.error = "Field can't be empty"
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.error = "Please enter a valid email address"
            false
        } else {
            textInputEmail.error = null
            true
        }
    }
    private fun validatePassword(): Boolean {
        val passwordInput = textInputPassword.editText?.text.toString().trim()
        return if (passwordInput.isEmpty()) {
            textInputPassword.error = "Field can't be empty"
            false
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputPassword.error = "Password too weak"
            false
        } else {
            textInputPassword.error = null
            true
        }
    }
    fun confirmInput(v: View) {
        if (!validateEmail() || !validatePassword()) {
            return
        }
        var input = "Email: " + textInputEmail.editText?.text.toString()
        input += "\n"
        input += "Password: " + textInputPassword.editText?.text.toString()
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
    }
}




