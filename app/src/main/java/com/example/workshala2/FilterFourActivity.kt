package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFilterfourBinding


class FilterFourActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterfourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterfourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView18.setOnClickListener {
            val intent = Intent(this, FilterOneActivity::class.java)
            startActivity(intent)
        }

    }
}