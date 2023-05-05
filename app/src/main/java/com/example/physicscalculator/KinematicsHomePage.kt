package com.example.physicscalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.physicscalculator.databinding.FragmentHomePageBinding
import com.example.physicscalculator.databinding.FragmentKinematicsHomePageBinding

class KinematicsHomePage : Fragment() {

    private var _binding: FragmentKinematicsHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentKinematicsHomePageBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.kinematicsGoButton.setOnClickListener{view->
            rootView.findNavController()
                .navigate(R.id.action_kinematicsHomePage_to_kinematicsAnswerPage)
        }

        return rootView
    }


}