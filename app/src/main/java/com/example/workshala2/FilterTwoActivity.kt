package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
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

        binding.view.setOnClickListener {
            val intent = Intent(this, FilterFiveActivity::class.java)
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