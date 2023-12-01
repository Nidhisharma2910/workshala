package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class profile_page_p : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile_page_p, container, false)

        // Assuming you have a button in your fragment layout with id 'buttonNavigate'
        val text = view.findViewById<TextView>(R.id.textView26)

        // Set a click listener for the button
        text.setOnClickListener {
            // Create an Intent to start the new activity (replace SecondActivity::class.java with your actual activity)
            val intent = Intent(activity, SettingActivity::class.java)

            // Start the new activity
            startActivity(intent)
        }

        return view
    }

    }
