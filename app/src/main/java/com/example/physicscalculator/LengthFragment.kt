package com.example.physicscalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.physicscalculator.databinding.FragmentLengthBinding
import com.example.physicscalculator.databinding.FragmentUnitsHomeBinding

class LengthFragment : Fragment() {

    private var _binding: FragmentLengthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLengthBinding.inflate(inflater, container, false)
        val rootView = binding.root

        return rootView
    }
}