package com.example.physicscalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import com.example.physicscalculator.databinding.FragmentLengthBinding
import com.example.physicscalculator.databinding.FragmentMassBinding


class MassFragment : Fragment() {

    private var _binding: FragmentMassBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MassViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMassBinding.inflate(inflater, container, false)
        val rootView = binding.root

        spinner()
        binding.unitsGoButton.setOnClickListener{view->
            viewModel.setInitVal(binding.ogValueEditText.text.toString())
            binding.answerTextView.text = viewModel.calculateMass().toString()
        }

        return rootView
    }
    fun spinner(){
        val initialUnitsArrayAdapter = ArrayAdapter.createFromResource(requireActivity(), R.array.mass_units,
            android.R.layout.simple_spinner_item)
        initialUnitsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.initialSpinner.adapter = initialUnitsArrayAdapter

        val finalUnitsArrayAdapter = ArrayAdapter.createFromResource(requireActivity(), R.array.mass_units,
            android.R.layout.simple_spinner_item)
        finalUnitsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.finalSpinner.adapter = finalUnitsArrayAdapter
    }
}