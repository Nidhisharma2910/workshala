package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.workshala2.databinding.ActivityFiltereightBinding

class FilterEightActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFiltereightBinding

    lateinit var Goggle: CheckBox
    lateinit var Amazon : CheckBox
    lateinit var Filpkart : CheckBox
    lateinit var Samsung: CheckBox
    lateinit var Lenovo: CheckBox
    lateinit var Accenture: CheckBox
    lateinit var IBM: CheckBox
    lateinit var Wipro: CheckBox
    lateinit var Dell: CheckBox
    lateinit var ClearFilter: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFiltereightBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.view.setOnClickListener {
            val intent = Intent(this, FilterFiveActivity::class.java)
            startActivity(intent)
        }

        binding.imageView1.setOnClickListener {
            val intent = Intent(this, FilterTwoActivity::class.java)
            startActivity(intent)
        }

         Goggle = findViewById(R.id.checkBox)
         Amazon= findViewById(R.id.checkBox2)
        Filpkart= findViewById(R.id.checkBox3)
         Samsung= findViewById(R.id.checkBox4)
        Lenovo= findViewById(R.id.checkBox5)
        Accenture= findViewById(R.id.checkBox6)
        IBM= findViewById(R.id.checkBox7)
        Wipro= findViewById(R.id.checkBox8)
        Dell= findViewById(R.id.checkBox9)
        ClearFilter = findViewById(R.id.textView32)

        ClearFilter.setOnClickListener{
            if(Goggle.isChecked()) {
                Goggle.setChecked(false)
            }
            if(Amazon.isChecked()) {
                Amazon.setChecked(false)
            }
            if(Filpkart.isChecked()) {
                Filpkart.setChecked(false)
            }
            if(Samsung.isChecked()) {
                Samsung.setChecked(false)
            }
            if(Lenovo.isChecked()) {
                Lenovo.setChecked(false)
            }
            if(Accenture.isChecked()) {
                Accenture.setChecked(false)
            }
            if(IBM.isChecked()) {
                IBM.setChecked(false)
            }
            if(Wipro.isChecked()) {
            Wipro.setChecked(false)
        }
            if(Dell.isChecked()) {
                Dell.setChecked(false)
            }

        }
    }
}