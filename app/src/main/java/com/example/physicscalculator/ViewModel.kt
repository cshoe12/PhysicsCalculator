package com.example.physicscalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {

    private var _initUnit = MutableLiveData("")
    val initUnit: LiveData<String>
        get() = _initUnit

    private var _finalUnit= MutableLiveData("")
    val finalUnit: LiveData<String>
        get() = _finalUnit

    private var _initVal = MutableLiveData("")
    val initVal: LiveData<String>
        get() = _initVal

    fun setInitUnit(strInit: String){
        _initUnit.value = strInit
    }

    fun setFinalUnit(strFinal: String){
        _finalUnit.value = strFinal
    }

    fun setInitVal(strVal: String){
        _initVal.value = strVal
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
        if(_initUnit.value == "g"){
            if(_finalUnit.value == "kg"){
                converted = fromGrams(_initVal.value?.toDouble() ?: 0.0, "kg")
            }
            else if(_finalUnit.value =="mg"){
                converted = fromGrams( _initVal.value?.toDouble() ?: 0.0, "mg")
            }
            else if(_finalUnit.value =="lbs"){
                converted = fromGrams(_initVal.value?.toDouble() ?: 0.0, "lbs")
            }
        }

        if(_initUnit.value == "kg"){
            var convertedGrams = toGrams("kg",_initVal.value?.toDouble() ?: 0.0)
            if(_finalUnit.value == "g"){
                converted = convertedGrams
            }
            else if(_finalUnit.value =="mg"){
                converted = fromGrams(convertedGrams, "mg")
            }
            else if(_finalUnit.value =="lbs"){
                converted = fromGrams(convertedGrams, "lbs")
            }
        }

        if(_initUnit.value == "mg") {
            var convertedGrams = toGrams("mg", _initVal.value?.toDouble() ?: 0.0)
            if (_finalUnit.value == "g") {
                converted = convertedGrams
            } else if (_finalUnit.value == "kg") {
                converted = fromGrams(convertedGrams, "kg")
            } else if (_finalUnit.value == "lbs") {
                converted = fromGrams(convertedGrams, "lbs")
            }
        }

        if(_initUnit.value == "lbs"){
            var convertedGrams = toGrams("mg", _initVal.value?.toDouble() ?: 0.0)
            if(_finalUnit.value == "g"){
                converted = convertedGrams
            }
            else if(_finalUnit.value =="mg"){
                converted = fromGrams(convertedGrams, "mg")
            }
            else if(_finalUnit.value =="kg"){
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
        if (_initUnit.value == "L") {
            if (_finalUnit.value == "mL") {
                converted = fromLiters(_initVal.value?.toDouble() ?: 0.0, "mL")
            } else if (_finalUnit.value == "cm^3") {
                converted = fromLiters(_initVal.value?.toDouble() ?: 0.0, "cm^3")
            } else if (_finalUnit.value == "gal") {
                converted = fromLiters(_initVal.value?.toDouble() ?: 0.0, "gal")
            }
        }

        if (_initUnit.value == "mL") {
            var convertedL = toLiters("mL", _initVal.value?.toDouble() ?: 0.0)
            if (_finalUnit.value == "L") {
                converted = convertedL
            } else if (_finalUnit.value == "cm^3") {
                converted = fromLiters(convertedL, "cm^3")
            } else if (_finalUnit.value == "gal") {
                converted = fromLiters(convertedL, "gal")
            }
        }

        if (_initUnit.value == "cm^3") {
            var convertedL = toLiters("cm^3",_initVal.value?.toDouble() ?: 0.0)
            if (_finalUnit.value == "L") {
                converted = convertedL
            } else if (_finalUnit.value == "mL") {
                converted = fromLiters(convertedL, "mL")
            } else if (_finalUnit.value == "gal") {
                converted = fromLiters(convertedL, "gal")
            }
        }

        if (_initUnit.value == "gal") {
            var convertedL = toLiters("gal", _initVal.value?.toDouble() ?: 0.0)
            if (_finalUnit.value == "L") {
                converted = convertedL
            } else if (_finalUnit.value == "cm^3") {
                converted = fromLiters(convertedL, "cm^3")
            } else if (_finalUnit.value == "mL") {
                converted = fromLiters(convertedL, "mL")
            }
        }
        return converted
    }
    fun calculateTime(): Double {
        var converted = 0.0
        if (_initUnit.value == "s") {
            if (_finalUnit.value == "nano-s") {
                converted = fromSeconds(_initVal.value?.toDouble() ?: 0.0, "nano-s")
            } else if (_finalUnit.value == "micro-s") {
                converted = fromSeconds(_initVal.value?.toDouble() ?: 0.0, "micro-s")
            } else if (_finalUnit.value == "milli-s") {
                converted = fromSeconds(_initVal.value?.toDouble() ?: 0.0, "milli-s")
            } else if (_finalUnit.value == "min") {
                converted = fromSeconds(_initVal.value?.toDouble() ?: 0.0, "min")
            } else if (_finalUnit.value == "hour") {
                converted = fromSeconds(_initVal.value?.toDouble() ?: 0.0, "hour")
            } else if (_finalUnit.value == "day") {
                converted = fromSeconds(_initVal.value?.toDouble() ?: 0.0, "day")
            } else if (_finalUnit.value == "year") {
                converted = fromSeconds(_initVal.value?.toDouble() ?: 0.0, "year")
            }
        }

        if (_initUnit.value == "nano-s") {
            var convertedSec = toSeconds("nano-s", _initVal.value?.toDouble() ?: 0.0)

            if (_finalUnit.value == "s") {
                converted = convertedSec
            } else if (_finalUnit.value == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit.value == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit.value == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit.value == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit.value == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit.value == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }

        if (_initUnit.value == "micro-s") {
            var convertedSec = toSeconds("micro-s", _initVal.value?.toDouble() ?: 0.0)

            if (_finalUnit.value == "s") {
                converted = convertedSec
            } else if (_finalUnit.value == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit.value == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit.value == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit.value == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit.value == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit.value == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }

        if (_initUnit.value == "milli-s") {
            var convertedSec = toSeconds("milli-s", _initVal.value?.toDouble() ?: 0.0)

            if (_finalUnit.value == "s") {
                converted = convertedSec
            } else if (_finalUnit.value == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit.value == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit.value == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit.value == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit.value == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit.value == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }
        if (_initUnit.value == "min") {
            var convertedSec = toSeconds("min", _initVal.value?.toDouble() ?: 0.0)

            if (_finalUnit.value == "s") {
                converted = convertedSec
            } else if (_finalUnit.value == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit.value == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit.value == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit.value == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit.value == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit.value == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }

        if (_initUnit.value == "hour") {
            var convertedSec = toSeconds("hour", _initVal.value?.toDouble() ?: 0.0)

            if (_finalUnit.value == "s") {
                converted = convertedSec
            } else if (_finalUnit.value == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit.value == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit.value == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit.value == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit.value == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit.value == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }
        if (_initUnit.value == "day") {
            var convertedSec = toSeconds("day", _initVal.value?.toDouble() ?: 0.0)

            if (_finalUnit.value == "s") {
                converted = convertedSec
            } else if (_finalUnit.value == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit.value == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit.value == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit.value == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit.value == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            } else if (_finalUnit.value == "year") {
                converted = fromSeconds(convertedSec, "year")
            }
        }

        if (_initUnit.value == "year") {
            var convertedSec = toSeconds("year", _initVal.value?.toDouble() ?: 0.0)

            if (_finalUnit.value == "s") {
                converted = convertedSec
            } else if (_finalUnit.value == "micro-s") {
                converted = fromSeconds(convertedSec, "micro-s")
            } else if (_finalUnit.value == "milli-s") {
                converted = fromSeconds(convertedSec, "milli-s")
            } else if (_finalUnit.value == "min") {
                converted = fromSeconds(convertedSec, "min")
            } else if (_finalUnit.value == "hour") {
                converted = fromSeconds(convertedSec, "hour")
            } else if (_finalUnit.value == "day") {
                converted = fromSeconds(convertedSec, "day")
            } else if (_finalUnit.value == "nano-s") {
                converted = fromSeconds(convertedSec, "nano-s")
            }
        }
        return converted
    }



    fun calculateLength(): Double{
        var converted: Double = 0.0
        if(_initUnit.value == "m"){
            if(_finalUnit.value =="cm"){
                converted = fromMeters(_initVal.value?.toDouble() ?: 0.0, "cm")
            }
            else if(_finalUnit.value =="km"){
                converted = fromMeters(_initVal.value?.toDouble() ?: 0.0, "km")
            }
            else if(_finalUnit.value =="mm"){
                converted = fromMeters(_initVal.value?.toDouble() ?: 0.0, "mm")
            }
            else if(_finalUnit.value =="micro-m"){
                converted = fromMeters(_initVal.value?.toDouble() ?: 0.0, "micro-m")
            }
            else if(_finalUnit.value =="nano-m"){
                converted = fromMeters(_initVal.value?.toDouble() ?: 0.0, "nano-m")
            }
            else if(_finalUnit.value =="ft"){
                converted = fromMeters(_initVal.value?.toDouble() ?: 0.0, "ft")
            }
            else if(_finalUnit.value =="in"){
                converted = fromMeters(_initVal.value?.toDouble() ?: 0.0, "in")
            }
            else if(_finalUnit.value =="yd"){
                converted = fromMeters(_initVal.value?.toDouble() ?: 0.0, "yd")
            }
            else if(_finalUnit.value =="mi"){
                converted = fromMeters(_initVal.value?.toDouble() ?: 0.0, "mi")
            }

        }

        if(_initUnit.value == "cm"){
            var convertedMeters = toMeters("cm", _initVal.value?.toDouble() ?: 0.0)
            if(_finalUnit.value =="m"){
                converted = convertedMeters
            }
            else if(_finalUnit.value =="km"){
                converted = fromMeters(convertedMeters, "km")
            }
            else if(_finalUnit.value =="mm"){
                converted = fromMeters(convertedMeters, "mm")
            }
            else if(_finalUnit.value =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")
            }
            else if(_finalUnit.value =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")
            }
            else if(_finalUnit.value =="ft"){
                converted = fromMeters(convertedMeters, "ft")
            }
            else if(_finalUnit.value =="in"){
                converted = fromMeters(convertedMeters, "in")
            }
            else if(_finalUnit.value =="yd"){
                converted = fromMeters(convertedMeters, "yd")
            }
            else if(_finalUnit.value =="mi"){
                converted = fromMeters(convertedMeters, "mi")
            }
        }

        if(_initUnit.value == "km"){
            var convertedMeters = toMeters("km", _initVal.value?.toDouble() ?: 0.0)
            if(_finalUnit.value =="cm"){
                converted = fromMeters(convertedMeters, "cm")
            }
            else if(_finalUnit.value =="m"){
                converted = convertedMeters
            }
            else if(_finalUnit.value =="mm"){
                converted = fromMeters(convertedMeters, "mm")
            }
            else if(_finalUnit.value =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")
            }
            else if(_finalUnit.value =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit.value =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit.value =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit.value =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit.value =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit.value == "mm"){
            var convertedMeters = toMeters("mm", _initVal.value?.toDouble() ?: 0.0)

            if(_finalUnit.value =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit.value =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit.value =="m"){
                converted = convertedMeters

            }
            else if(_finalUnit.value =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit.value =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit.value =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit.value =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit.value =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit.value =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }
        if(_initUnit.value == "micro-m"){
            var convertedMeters = toMeters("micro-m", _initVal.value?.toDouble() ?: 0.0)

            if(_finalUnit.value =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit.value =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit.value =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit.value =="m"){
                converted = convertedMeters

            }
            else if(_finalUnit.value =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit.value =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit.value =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit.value =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit.value =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit.value == "nano-m"){
            var convertedMeters = toMeters("nano-m", _initVal.value?.toDouble() ?: 0.0)
            if(_finalUnit.value =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit.value =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit.value =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit.value =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit.value =="m"){
                converted = convertedMeters

            }
            else if(_finalUnit.value =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit.value =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit.value =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit.value =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit.value == "ft"){
            var convertedMeters = toMeters("ft", _initVal.value?.toDouble() ?: 0.0)

            if(_finalUnit.value =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit.value =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit.value =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit.value =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit.value =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit.value =="m"){
                converted = convertedMeters
            }
            else if(_finalUnit.value =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit.value =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit.value =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit.value == "in"){
            var convertedMeters = toMeters("in", _initVal.value?.toDouble() ?: 0.0)

            if(_finalUnit.value =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit.value =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit.value =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit.value =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit.value =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit.value =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit.value =="m"){
                converted = convertedMeters

            }
            else if(_finalUnit.value =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit.value =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit.value == "yd"){
            var convertedMeters = toMeters("in", _initVal.value?.toDouble() ?: 0.0)

            if(_finalUnit.value =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit.value =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit.value =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit.value =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit.value =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit.value =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit.value =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit.value =="m"){
                converted = convertedMeters
            }
            else if(_finalUnit.value =="mi"){
                converted = fromMeters(convertedMeters, "mi")

            }
        }

        if(_initUnit.value == "mi"){
            var convertedMeters = toMeters("in", _initVal.value?.toDouble() ?: 0.0)

            if(_finalUnit.value =="cm"){
                converted = fromMeters(convertedMeters, "cm")

            }
            else if(_finalUnit.value =="km"){
                converted = fromMeters(convertedMeters, "km")

            }
            else if(_finalUnit.value =="mm"){
                converted = fromMeters(convertedMeters, "mm")

            }
            else if(_finalUnit.value =="micro-m"){
                converted = fromMeters(convertedMeters, "micro-m")

            }
            else if(_finalUnit.value =="nano-m"){
                converted = fromMeters(convertedMeters, "nano-m")

            }
            else if(_finalUnit.value =="ft"){
                converted = fromMeters(convertedMeters, "ft")

            }
            else if(_finalUnit.value =="in"){
                converted = fromMeters(convertedMeters, "in")

            }
            else if(_finalUnit.value =="yd"){
                converted = fromMeters(convertedMeters, "yd")

            }
            else if(_finalUnit.value =="m"){
                converted = convertedMeters
            }
        }
        return converted
    }

}