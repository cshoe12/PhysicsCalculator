package com.example.physicscalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.physicscalculator.databinding.ListItemLayoutBinding

class PastConversionAdapter(val conversionList: List<PastConversion>) : RecyclerView.Adapter<PastConversionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastConversionViewHolder {
        val binding = ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PastConversionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PastConversionViewHolder, position: Int) {
        val current = conversionList[position]
        holder.bindPastConversion(current)
    }

    override fun getItemCount(): Int {
        return conversionList.size
    }
}