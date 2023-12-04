package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFiltertwoBinding

class FilterTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFiltertwoBinding
    lateinit var Male : CheckBox
    lateinit var Female : CheckBox
    lateinit var Others : CheckBox
    lateinit var ClearFilter : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltertwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val back = findViewById<ImageView>(R.id.imageView17)
        back.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

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


        Male = findViewById(R.id.checkBox)
        Female = findViewById(R.id.checkBox2)
        Others = findViewById(R.id.checkBox3)
        ClearFilter = findViewById(R.id.textView32)

        ClearFilter.setOnClickListener{
            if(Male.isChecked()) {
                Male.setChecked(false)
            }
            if(Female.isChecked()) {
                Female.setChecked(false)
            }
            if(Others.isChecked()) {
                Others.setChecked(false)
            }

        }



    }
}