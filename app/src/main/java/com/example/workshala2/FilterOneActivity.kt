package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFillteroneBinding

class FilterOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFillteroneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFillteroneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView1.setOnClickListener {
            val intent = Intent(this, FilterTwoActivity::class.java)
            startActivity(intent)
        }
    }
}