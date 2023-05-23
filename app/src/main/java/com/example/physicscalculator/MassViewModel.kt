package com.example.physicscalculator

import androidx.lifecycle.ViewModel

class MassViewModel: ViewModel() {

    private var _initUnit = ""
    val initUnit: String
        get() = _initUnit

    private var _finalUnit= ""
    val finalUnit: String
        get() = _finalUnit

    private var _initVal = ""
    val initVal: String
        get() = _initVal

    fun setInitUnit(strInit: String){
        _initUnit = strInit
    }

    fun setFinalUnit(strFinal: String){
        _finalUnit = strFinal
    }

    fun setInitVal(strVal: String){
        _initVal = strVal
    }

    //from everything else to grams
    fun toGrams(currentUnit: String, num: Double): Double{
        var grams = 0.0
        if(currentUnit == "kg"){
            grams = num * 1000
        }
        else if(currentUnit == "mg"){
            grams = num / 1000
        }
        else if(currentUnit == "lbs"){
            grams = (num / 2.2046) * 1000
        }
        return grams
    }

    //from grams to everything else
    fun fromGrams(numInGrams: Double, desiredUnit: String): Double{
        var new = 0.0
        if(desiredUnit == "kg"){
            new = numInGrams / 1000
        }
        else if(desiredUnit == "mg"){
            new = numInGrams * 1000
        }
        else if(desiredUnit == "lbs"){
            new = (numInGrams / 1000) * 2.2046
        }
        return new

    }

    fun calculateMass(): Double{
        var converted = 0.0
        if(_initUnit == "g"){
            if(_finalUnit == "kg"){
                converted = fromGrams(_initVal.toDouble(), "kg")
            }
            else if(_finalUnit =="mg"){
                converted = fromGrams( _initVal.toDouble(), "mg")
            }
            else if(_finalUnit =="lbs"){
                converted = fromGrams(_initVal.toDouble(), "lbs")
            }
        }

        if(_initUnit == "kg"){
            var convertedGrams = toGrams("kg", _initVal.toDouble())
            if(_finalUnit == "g"){
                converted = convertedGrams
            }
            else if(_finalUnit =="mg"){
                converted = fromGrams(convertedGrams, "mg")
            }
            else if(_finalUnit =="lbs"){
                converted = fromGrams(convertedGrams, "lbs")
            }
        }

        if(_initUnit == "mg") {
            var convertedGrams = toGrams("mg", _initVal.toDouble())
            if (_finalUnit == "g") {
                converted = convertedGrams
            } else if (_finalUnit == "kg") {
                converted = fromGrams(convertedGrams, "kg")
            } else if (_finalUnit == "lbs") {
                converted = fromGrams(convertedGrams, "lbs")
            }
        }

        if(_initUnit == "lbs"){
            var convertedGrams = toGrams("mg", _initVal.toDouble())
            if(_finalUnit == "g"){
                converted = convertedGrams
            }
            else if(_finalUnit =="mg"){
                converted = fromGrams(convertedGrams, "mg")
            }
            else if(_finalUnit =="kg"){
                converted = fromGrams(convertedGrams, "lbs")
            }
        }
        return converted
    }
}