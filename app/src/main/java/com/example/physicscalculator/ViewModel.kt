package com.example.physicscalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    private val _conversionList = mutableListOf<PastConversion>()
    val conversionList: List<PastConversion>
        get() = _conversionList

    private var _initUnit = ""
    val initUnit: String
        get() = _initUnit

    private var _finalUnit= ""
    val finalUnit: String
        get() = _finalUnit

    private var _initVal = ""
    val initVal: String
        get() = _initVal

//    private var _finalVal = ""
//    val finalVal: String
//        get() = _finalVal

    fun setInitUnit(strInit: String){
        _initUnit = strInit
    }

    fun setFinalUnit(strFinal: String){
        _finalUnit = strFinal
    }

    fun setInitVal(strVal: String){
        _initVal = strVal
    }
//
//    fun setFinalVal(strVal: String){
//        _finalVal = strVal
//    }

    fun addToList(new: PastConversion){
        _conversionList.add(new)
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
            if(_finalUnit== "kg"){
                converted = fromGrams(_initVal.toDouble(), "kg")
            }
            else if(_finalUnit == "mg"){
                converted = fromGrams(_initVal.toDouble(), "mg")
            }
            else if(_finalUnit == "lbs"){
                converted = fromGrams(_initVal.toDouble(), "lbs")
            }
        }

        if(_initUnit == "kg"){
            var convertedGrams = toGrams("kg",_initVal.toDouble())
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
    fun toMeters(currentUnit: String, num : Double): Double{
        var meters = 0.0
        if(currentUnit =="cm"){
            meters = num / 100
        }
        else if(currentUnit =="km"){
            meters = num * 1000
        }
        else if(currentUnit =="mm"){
            meters = num / 1000
        }
        else if(currentUnit =="micro-m"){
            meters = num / 1000000
        }
        else if(currentUnit =="nano-m"){
            meters = num / 1000000000
        }
        else if(currentUnit =="ft"){
            meters = (num * 12) / 39.37
        }
        else if(currentUnit =="in"){
            meters = num / 39.37
        }
        else if(currentUnit =="yd"){
            meters = (num * 36) / 39.37

        }
        else if(currentUnit =="mi"){
            meters = (num / 0.621) * 1000
        }
        else if(currentUnit =="angstrom"){
            meters = (num * 4000000000) / 39.37
        }
        return meters
    }
    //from meters to all of the rest of them
    //pass in value in meters and then converts to desired unit (other parameter)

    fun fromMeters(numInMeters: Double, desiredUnit: String): Double{
        var new = 0.0
        if(desiredUnit =="cm"){
            new = numInMeters * 100
        }
        else if(desiredUnit =="km"){
            new = numInMeters / 1000
        }
        else if(desiredUnit =="mm"){
            new = numInMeters * 1000
        }
        else if(desiredUnit =="micro-m"){
            new = numInMeters * 1000000
        }
        else if(desiredUnit =="nano-m"){
            new = numInMeters * 1000000000
        }
        else if(desiredUnit =="ft"){
            new = (numInMeters * 39.37) / 12
        }
        else if(desiredUnit =="in"){
            new = numInMeters * 39.37
        }
        else if(desiredUnit =="yd"){
            new = (numInMeters *39.37) / 36
        }
        else if(desiredUnit =="mi"){
            new = (numInMeters / 1000) * 0.621
        }

        return new
    }

    //from everything to seconds
    fun toSeconds(currentUnit: String, num: Double): Double {
        var sec = 0.0
        if (currentUnit == "nano-s") {
            sec = num / 1000000000
        } else if (currentUnit == "milli-s") {
            sec = num / 1000
        } else if (currentUnit == "min") {
            sec = num * 60
        } else if (currentUnit == "hour") {
            sec = num * 3600
        } else if (currentUnit == "day") {
            sec = num * 24 * 3600
        } else if (currentUnit == "week") {
            sec = num * 7 * 24 * 3600
        } else if (currentUnit == "year") {
            sec = num * 365 * 7 * 24 * 3600
        }
        return sec
    }

    //from seconds to everything else
    fun fromSeconds(numInSec: Double, desiredUnit: String): Double {
        var new = 0.0
        if (desiredUnit == "nano-s") {
            new = numInSec * 1000000000
        } else if (desiredUnit == "milli-s") {
            new = numInSec * 1000
        } else if (desiredUnit == "min") {
            new = numInSec / 60
        } else if (desiredUnit == "hour") {
            new = numInSec / 3600
        } else if (desiredUnit == "day") {
            new = numInSec / 24 / 3600
        } else if (desiredUnit == "week") {
            new = numInSec / 7 / 24 / 3600
        } else if (desiredUnit == "year") {
            new = numInSec / 365 / 7 / 24 / 3600
        }
        return new
    }
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

    fun calculateVolume(): Double {
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
            var convertedL = toLiters("cm^3",_initVal.toDouble())
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
    fun calculateTime(): Double {
        var converted = 0.0
        if (_initUnit == "s") {
            if (_finalUnit == "nano-s") {
                converted = fromSeconds(_initVal.toDouble(), "nano-s")
            } else if (_finalUnit == "micro-s") {
                converted = fromSeconds(_initVal.toDouble(), "micro-s")
            } else if (_finalUnit == "milli-s") {
                converted = fromSeconds(_initVal.toDouble(), "milli-s")
            } else if (_finalUnit == "min") {
                converted = fromSeconds(_initVal.toDouble(), "min")
            } else if (_finalUnit == "hour") {
                converted = fromSeconds(_initVal.toDouble(), "hour")
            } else if (_finalUnit == "day") {
                converted = fromSeconds(_initVal.toDouble(), "day")
            } else if (_finalUnit == "year") {
                converted = fromSeconds(_initVal.toDouble(), "year")
            }
        }

        if (_initUnit == "nano-s") {
            var convertedSec = toSeconds("nano-s",_initVal.toDouble())

            if (_finalUnit == "s") {
                converted = convertedSec
            } else if (_finalUnit == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }

        if (_initUnit == "micro-s") {
            var convertedSec = toSeconds("micro-s", _initVal.toDouble())

            if (_finalUnit == "s") {
                converted = convertedSec
            } else if (_finalUnit == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }

        if (_initUnit == "milli-s") {
            var convertedSec = toSeconds("milli-s", _initVal.toDouble())

            if (_finalUnit == "s") {
                converted = convertedSec
            } else if (_finalUnit == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }
        if (_initUnit == "min") {
            var convertedSec = toSeconds("min", _initVal.toDouble())

            if (_finalUnit == "s") {
                converted = convertedSec
            } else if (_finalUnit == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }

        if (_initUnit == "hour") {
            var convertedSec = toSeconds("hour",_initVal.toDouble())

            if (_finalUnit == "s") {
                converted = convertedSec
            } else if (_finalUnit == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }
        if (_initUnit == "day") {
            var convertedSec = toSeconds("day", _initVal.toDouble())

            if (_finalUnit == "s") {
                converted = convertedSec
            } else if (_finalUnit == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }

        if (_initUnit == "year") {
            var convertedSec = toSeconds("year", _initVal.toDouble())

            if (_finalUnit == "s") {
                converted = convertedSec
            } else if (_finalUnit == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            }
        }
        return converted
    }



    fun calculateLength(): Double{
        var converted: Double = 0.0
        if(_initUnit == "m"){
            if(_finalUnit =="cm"){
                converted = fromMeters(_initVal.toDouble(), "cm")
            }
            else if(_finalUnit =="km"){
                converted = fromMeters(_initVal.toDouble(), "km")
            }
            else if(_finalUnit =="mm"){
                converted = fromMeters(_initVal.toDouble(), "mm")
            }
            else if(_finalUnit =="micro-m"){
                converted = fromMeters(_initVal.toDouble(), "micro-m")
            }
            else if(_finalUnit =="nano-m"){
                converted = fromMeters(_initVal.toDouble(), "nano-m")
            }
            else if(_finalUnit =="ft"){
                converted = fromMeters(_initVal.toDouble(), "ft")
            }
            else if(_finalUnit =="in"){
                converted = fromMeters(_initVal.toDouble(), "in")
            }
            else if(_finalUnit =="yd"){
                converted = fromMeters(_initVal.toDouble(), "yd")
            }
            else if(_finalUnit =="mi"){
                converted = fromMeters(_initVal.toDouble(), "mi")
            }

        }

        if(_initUnit == "cm"){
            var convertedMeters = toMeters("cm", _initVal.toDouble())
            if(_finalUnit =="m"){
                converted = convertedMeters
            }
            else if(_finalUnit =="km"){
                converted = fromMeters(convertedMeters, "km")
            }
            else if(_finalUnit =="mm"){
                converted = fromMeters(convertedMeters, "mm")
            }
            else if(_finalUnit =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")
            }
            else if(_finalUnit =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")
            }
            else if(_finalUnit =="ft"){
                converted = fromMeters(convertedMeters, "ft")
            }
            else if(_finalUnit =="in"){
                converted = fromMeters(convertedMeters, "in")
            }
            else if(_finalUnit =="yd"){
                converted = fromMeters(convertedMeters, "yd")
            }
            else if(_finalUnit =="mi"){
                converted = fromMeters(convertedMeters, "mi")
            }
        }

        if(_initUnit == "km"){
            var convertedMeters = toMeters("km", _initVal.toDouble())
            if(_finalUnit =="cm"){
                converted = fromMeters(convertedMeters, "cm")
            }
            else if(_finalUnit =="m"){
                converted = convertedMeters
            }
            else if(_finalUnit =="mm"){
                converted = fromMeters(convertedMeters, "mm")
            }
            else if(_finalUnit =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")
            }
            else if(_finalUnit =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit == "mm"){
            var convertedMeters = toMeters("mm", _initVal.toDouble())

            if(_finalUnit =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit =="m"){
                converted = convertedMeters

            }
            else if(_finalUnit =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }
        if(_initUnit == "micro-m"){
            var convertedMeters = toMeters("micro-m", _initVal.toDouble())

            if(_finalUnit =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit =="m"){
                converted = convertedMeters

            }
            else if(_finalUnit =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit == "nano-m"){
            var convertedMeters = toMeters("nano-m", _initVal.toDouble())
            if(_finalUnit =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit =="m"){
                converted = convertedMeters

            }
            else if(_finalUnit =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit == "ft"){
            var convertedMeters = toMeters("ft", _initVal.toDouble())

            if(_finalUnit =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit =="m"){
                converted = convertedMeters
            }
            else if(_finalUnit =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit == "in"){
            var convertedMeters = toMeters("in", _initVal.toDouble())

            if(_finalUnit =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit =="m"){
                converted = convertedMeters

            }
            else if(_finalUnit =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit == "yd"){
            var convertedMeters = toMeters("in", _initVal.toDouble())

            if(_finalUnit =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit =="m"){
                converted = convertedMeters
            }
            else if(_finalUnit =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit == "mi"){
            var convertedMeters = toMeters("in", _initVal.toDouble())

            if(_finalUnit =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit =="m"){
                converted = convertedMeters
            }
        }
        return converted
    }

}