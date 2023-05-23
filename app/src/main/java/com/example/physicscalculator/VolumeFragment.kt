package com.example.physicscalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.viewModels
import com.example.physicscalculator.databinding.FragmentVolumeBinding

class VolumeFragment : Fragment() {

    private var _binding: FragmentVolumeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: VolumeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVolumeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        spinner()
        binding.unitsGoButton.setOnClickListener{view->
            viewModel.setInitVal(binding.ogValueEditText.text.toString())
            binding.answerTextView.text = viewModel.calculate().toString()
        }

        return rootView
    }
    fun spinner(){
        val initialUnitsArrayAdapter = ArrayAdapter.createFromResource(requireActivity(), R.array.volume_units,
            android.R.layout.simple_spinner_item)
        initialUnitsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.initialSpinner.adapter = initialUnitsArrayAdapter

        binding.initialSpinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, childView: View?, position: Int, ItemId: Long) {
                viewModel.setInitUnit(adapterView.getItemAtPosition(position).toString())
            }
            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }

        val finalUnitsArrayAdapter = ArrayAdapter.createFromResource(requireActivity(), R.array.volume_units,
            android.R.layout.simple_spinner_item)
        finalUnitsArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.finalSpinner.adapter = finalUnitsArrayAdapter

        binding.finalSpinner.onItemSelectedListener = object:
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, childView: View?, position: Int, ItemId: Long) {
                viewModel.setFinalUnit(adapterView.getItemAtPosition(position).toString())
            }
            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }
    }
}


