package com.example.physicscalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.physicscalculator.databinding.FragmentHomePageBinding
import com.example.physicscalculator.databinding.FragmentUnitsHomeBinding

class UnitsHomeFragment : Fragment() {

    private var _binding: FragmentUnitsHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUnitsHomeBinding.inflate(inflater, container, false)
        val rootView = binding.root
        binding.lengthButton.setOnClickListener{view->
            rootView.findNavController()
                .navigate(R.id.action_unitsHomeFragment_to_lengthFragment)
        }
        binding.massButton.setOnClickListener{view->
            rootView.findNavController()
                .navigate(R.id.action_unitsHomeFragment_to_massFragment)
        }
        binding.volumeButton.setOnClickListener{view->
            rootView.findNavController()
                .navigate(R.id.action_unitsHomeFragment_to_volumeFragment)
        }
        binding.timeButton.setOnClickListener{view->
            rootView.findNavController()
                .navigate(R.id.action_unitsHomeFragment_to_timeFragment)
        }

        binding.pastButton.setOnClickListener { view->
            rootView.findNavController()
                .navigate(R.id.action_unitsHomeFragment_to_pastConversionsFragment)
        }

        return rootView
    }
}