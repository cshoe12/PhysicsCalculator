package com.example.physicscalculator

import androidx.lifecycle.ViewModel

class VolumeViewModel: ViewModel() {

    private var _initUnit = ""
    val initUnit: String
        get() = _initUnit

    private var _finalUnit = ""
    val finalUnit: String
        get() = _finalUnit

    private var _initVal = ""
    val initVal: String
        get() = _initVal

    fun setInitUnit(strInit: String) {
        _initUnit = strInit
    }

    fun setFinalUnit(strFinal: String) {
        _finalUnit = strFinal
    }

    fun setInitVal(strVal: String) {
        _initVal = strVal
    }

    //from everything else to liters
    fun toLiters(currentUnit: String, num: Double): Double {
        var l = 0.0
        if (currentUnit == "mL") {
            l = num / 1000
        } else if (currentUnit == "cm^3") {
            l = num / 1000
        } else if (currentUnit == "gal") {
            l = num * 3.785
        }
        return l
    }

    //from liters to everything else
    fun fromLiters(numInL: Double, desiredUnit: String): Double {
        var new = 0.0
        if (desiredUnit == "mL") {
            new = numInL * 1000
        } else if (desiredUnit == "cm^3") {
            new = numInL * 1000
        } else if (desiredUnit == "gal") {
            new = numInL / 3.785
        }
        return new
    }

    fun calculate(): Double {
        var converted = 0.0
        if (_initUnit == "L") {
            if (_finalUnit == "mL") {
                converted = fromLiters(_initVal.toDouble(), "mL")
            } else if (_finalUnit == "cm^3") {
                converted = fromLiters(_initVal.toDouble(), "cm^3")
            } else if (_finalUnit == "gal") {
                converted = fromLiters(_initVal.toDouble(), "gal")
            }
        }

        if (_initUnit == "mL") {
            var convertedL = toLiters("mL", _initVal.toDouble())
            if (_finalUnit == "L") {
                converted = convertedL
            } else if (_finalUnit == "cm^3") {
                converted = fromLiters(convertedL, "cm^3")
            } else if (_finalUnit == "gal") {
                converted = fromLiters(convertedL, "gal")
            }
        }

        if (_initUnit == "cm^3") {
            var convertedL = toLiters("cm^3", _initVal.toDouble())
            if (_finalUnit == "L") {
                converted = convertedL
            } else if (_finalUnit == "mL") {
                converted = fromLiters(convertedL, "mL")
            } else if (_finalUnit == "gal") {
                converted = fromLiters(convertedL, "gal")
            }
        }

        if (_initUnit == "gal") {
            var convertedL = toLiters("gal", _initVal.toDouble())
            if (_finalUnit == "L") {
                converted = convertedL
            } else if (_finalUnit == "cm^3") {
                converted = fromLiters(convertedL, "cm^3")
            } else if (_finalUnit == "mL") {
                converted = fromLiters(convertedL, "mL")
            }
        }
        return converted
    }
}