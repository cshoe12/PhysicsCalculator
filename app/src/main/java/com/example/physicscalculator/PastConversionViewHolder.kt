package com.example.physicscalculator

import androidx.recyclerview.widget.RecyclerView
import com.example.physicscalculator.databinding.ListItemLayoutBinding

class PastConversionViewHolder(val binding: ListItemLayoutBinding):
    RecyclerView.ViewHolder(binding.root) {

    private lateinit var currentPastConversion: PastConversion

    fun bindPastConversion(pc: PastConversion){
        currentPastConversion = pc
        binding.iUnitTextView.text = pc.initialUnit
        binding.fUnitTextView.text = pc.finalUnit
        binding.iValTextView.text = pc.initialNum
        binding.fValTextView.text = pc.finalNum
    }


}