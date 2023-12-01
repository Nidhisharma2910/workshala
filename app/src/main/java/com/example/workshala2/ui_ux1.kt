package com.example.workshala2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ui_ux1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_ux1)

        val upload = findViewById<Button>(R.id.button2)
        upload.setOnClickListener{
            val intent = Intent(this, ui_ux2::class.java)
            startActivity(intent)
        }
    }
}