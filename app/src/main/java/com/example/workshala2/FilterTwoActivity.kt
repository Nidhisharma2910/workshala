package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFiltertwoBinding

class FilterTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFiltertwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltertwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.view.setOnClickListener {
            val intent = Intent(this, FilterFiveActivity::class.java)
            startActivity(intent)
        }

    }
}