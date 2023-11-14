package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFiltereightBinding

class FilterEightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFiltereightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltereightBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}