package com.example.physicscalculator

import androidx.lifecycle.LiveData

data class PastConversion(val initialNum: LiveData<String>, val finalNum: String, val initialUnit: LiveData<String>, val finalUnit: LiveData<String>)