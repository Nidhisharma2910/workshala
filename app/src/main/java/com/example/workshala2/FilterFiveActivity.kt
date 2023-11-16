package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFilterfiveBinding

class FilterFiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterfiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterfiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.view4.setOnClickListener {
            val intent = Intent(this, FilterEightActivity::class.java)
            startActivity(intent)
        }

    }
}

