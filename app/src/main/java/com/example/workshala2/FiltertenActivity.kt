package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFiltertenBinding
import com.example.workshala2.databinding.ActivityFiltertwoBinding

class FiltertenActivity: AppCompatActivity() {
    private lateinit var binding: ActivityFiltertenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltertenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.view7.setOnClickListener {
            val intent = Intent(this, FilterOneActivity::class.java)
            startActivity(intent)
        }

        binding.imageView1.setOnClickListener {
            val intent = Intent(this, FilterTwoActivity::class.java)
            startActivity(intent)
        }

        binding.imageView18.setOnClickListener {
            val intent = Intent(this, filter_three::class.java)
            startActivity(intent)
        }

        binding.imageView2.setOnClickListener {
            val intent = Intent(this, FilterFourActivity::class.java)
            startActivity(intent)
        }

        binding.view.setOnClickListener {
            val intent = Intent(this, FilterFiveActivity::class.java)
            startActivity(intent)
        }
        binding.view2.setOnClickListener {
            val intent = Intent(this, filter_six::class.java)
            startActivity(intent)
        }
        binding.view3.setOnClickListener {
            val intent = Intent(this, FilterSevenActivity::class.java)
            startActivity(intent)
        }
        binding.view4.setOnClickListener {
            val intent = Intent(this, FilterEightActivity::class.java)
            startActivity(intent)
        }

        binding.view5.setOnClickListener {
            val intent = Intent(this, filter_nine::class.java)
            startActivity(intent)
        }
        binding.view7.setOnClickListener {
            val intent = Intent(this, FiltertenActivity::class.java)
            startActivity(intent)
        }


    }
}