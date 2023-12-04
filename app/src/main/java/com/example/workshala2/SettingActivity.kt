package com.example.workshala2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class SettingActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)


        bottomNavigationView = findViewById(R.id.bottomNavigationView2)


        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val handled = when (menuItem.itemId) {
                R.id.home -> {
                    replaceFragment(home_page_p())
                    true
                }
                R.id.courses -> {
                    Toast.makeText(this, "already in homepage", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.job -> {
                    replaceFragment(job_page_p())
                    true
                }
                R.id.profile -> {
                    replaceFragment(profile_page_p())
                    true
                }
                else -> false
            }
            handled

        }


    }

    private fun replaceFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
        }

    }
