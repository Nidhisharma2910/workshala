package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFiltersevenBinding


class FilterSevenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFiltersevenBinding

    lateinit var Designn : CheckBox
    lateinit var Marketing : CheckBox
    lateinit var Music : CheckBox
    lateinit var Sales : CheckBox
    lateinit var Health : CheckBox
    lateinit var Manangement : CheckBox
    lateinit var Software : CheckBox
    lateinit var Media : CheckBox
    lateinit var Writing : CheckBox
    lateinit var ClearFilter : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltersevenBinding.inflate(layoutInflater)
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



        Designn = findViewById(R.id.checkBox)
        Marketing = findViewById(R.id.checkBox2)
        Music = findViewById(R.id.checkBox3)
        Sales = findViewById(R.id.checkBox4)
        Health = findViewById(R.id.checkBox5)
        Manangement= findViewById(R.id.checkBox6)
        Software = findViewById(R.id.checkBox7)
        Media = findViewById(R.id.checkBox8)
        Writing = findViewById(R.id.checkBox9)
        ClearFilter = findViewById(R.id.textView32)

        ClearFilter.setOnClickListener{
            if(Designn.isChecked()) {
                Designn.setChecked(false)
            }
            if(Marketing.isChecked()) {
                Marketing.setChecked(false)
            }
            if(Music.isChecked()) {
                Music.setChecked(false)
            }
            if(Sales.isChecked()) {
                Music.setChecked(false)
            }
            if(Health.isChecked()) {
                Music.setChecked(false)
            }
            if(Manangement.isChecked()) {
                Music.setChecked(false)
            }
            if(Software.isChecked()) {
                Music.setChecked(false)
            }
            if(Media.isChecked()) {
                Music.setChecked(false)
            }
            if(Writing.isChecked()) {
                Music.setChecked(false)
            }

        }



    }
}