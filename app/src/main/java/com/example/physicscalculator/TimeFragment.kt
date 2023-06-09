package com.example.physicscalculator

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

import com.example.physicscalculator.databinding.FragmentTimeBinding
import com.google.android.material.snackbar.Snackbar

class TimeFragment : Fragment() {

    private var _binding: FragmentTimeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModel by activityViewModels()

    lateinit var media: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTimeBinding.inflate(inflater, container, false)
        val rootView = binding.root

        spinner()
        binding.unitsGoButton.setOnClickListener{view->
            viewModel.setInitVal(binding.ogValueEditText.text.toString())

            if(viewModel.initUnit == viewModel.finalUnit){
                Toast.makeText(activity, R.string.same_units, Toast.LENGTH_SHORT).show()
            }
            else if(viewModel.initVal == ""){
                Snackbar.make(
                    binding.myCoordinatorLayout,
                    R.string.no_value,
                    Snackbar.LENGTH_SHORT
                ).show()

            }
            else {
                val response = viewModel.calculateTime().toString()
                viewModel.addToList(PastConversion(viewModel.initVal, response, viewModel.initUnit, viewModel.finalUnit))
                binding.answerTextView.text = response
                media = MediaPlayer.create(context, R.raw.answer)
                media.start()
            }
        }


        return rootView
    }
    fun spinner(){
        val initialUnitsArrayAdapter = ArrayAdapter.createFromResource(requireActivity(), R.array.time_units,
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

        val finalUnitsArrayAdapter = ArrayAdapter.createFromResource(requireActivity(), R.array.time_units,
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