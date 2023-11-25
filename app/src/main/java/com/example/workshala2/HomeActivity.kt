package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text


class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val job=findViewById<TextView>(R.id.textView41)
        job.setOnClickListener {
            val intent= Intent(this,JobActivity::class.java)
            startActivity(intent)
        }


        val aboutDoc=findViewById<TextView>(R.id.textView38)
        aboutDoc.setOnClickListener{
            val intent= Intent(this,AndroidLargeActivity::class.java)
            startActivity(intent)


    }

    }
}


