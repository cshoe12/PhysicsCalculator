package com.example.physicscalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.physicscalculator.databinding.FragmentLengthBinding
import com.example.physicscalculator.databinding.FragmentPastConversionsBinding

class PastConversionsFragment : Fragment() {

    private var _binding: FragmentPastConversionsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPastConversionsBinding.inflate(inflater, container, false)
        val rootView = binding.root





        return rootView
    }

}