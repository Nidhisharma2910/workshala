package com.example.workshala2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.workshala2.databinding.ActivityJobbBinding

class JobbActivity: AppCompatActivity() {
    private lateinit var binding: ActivityJobbBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobbBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}