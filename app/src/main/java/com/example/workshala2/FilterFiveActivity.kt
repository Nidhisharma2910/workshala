package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
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

        binding.view4.setOnClickListener {
            val intent = Intent(this, FilterEightActivity::class.java)
            startActivity(intent)
        }

        binding.imageView1.setOnClickListener {
            val intent = Intent(this, FilterTwoActivity::class.java)
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

