package com.example.workshala2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workshala2.databinding.FragmentJobPagePBinding

class JobPagePFragment : Fragment() {
    private var _binding: FragmentJobPagePBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout using ViewBinding
        _binding = FragmentJobPagePBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Use binding to set click listener for the job button

    }

    override fun onDestroyView() {
        super.onDestroyView()
// Clean up the binding instance when the fragment view is destroyed
        _binding = null
    }
}