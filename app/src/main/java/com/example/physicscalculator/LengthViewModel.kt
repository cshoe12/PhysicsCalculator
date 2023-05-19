package com.example.physicscalculator

import androidx.lifecycle.ViewModel

class LengthViewModel: ViewModel() {

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

    //all of the rest of them to meters
    //pass in value and current unit
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

    fun calculate(): Double{
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