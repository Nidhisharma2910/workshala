package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFilterfiveBinding

class FilterFiveActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFilterfiveBinding

    lateinit var twohr : CheckBox
    lateinit var fourhr : CheckBox
    lateinit var sixhr : CheckBox
    lateinit var eighthr : CheckBox
    lateinit var ClearFilter: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterfiveBinding.inflate(layoutInflater)
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


        twohr = findViewById(R.id.checkBox)
        fourhr = findViewById(R.id.checkBox2)
        sixhr = findViewById(R.id.checkBox3)
        eighthr = findViewById(R.id.checkBox4)
        ClearFilter = findViewById(R.id.textView32)

        ClearFilter.setOnClickListener{
            if(twohr.isChecked()) {
                twohr.setChecked(false)
            }
            if(fourhr.isChecked()) {
                fourhr.setChecked(false)
            }
            if(sixhr.isChecked()) {
                sixhr.setChecked(false)
            }
            if(eighthr.isChecked()) {
                eighthr.setChecked(false)
            }

        }



    }
}

