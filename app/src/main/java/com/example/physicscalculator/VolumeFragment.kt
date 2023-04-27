package com.example.physicscalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.physicscalculator.databinding.FragmentVolumeBinding

class VolumeFragment : Fragment() {

    private var _binding: FragmentVolumeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVolumeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        val unitsArrayAdapter = ArrayAdapter.createFromResource(requireActivity(), R.array.volume_units,
            android.R.layout.simple_spinner_item)
        unitsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
       binding.VinitialSpinner.adapter = unitsArrayAdapter


        return rootView
    }

}