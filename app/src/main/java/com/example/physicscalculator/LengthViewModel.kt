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

    fun toMeters(unit: String, init : Double): Double{
        var meters = 0.0
        if(unit =="cm"){
            meters = init * 100
        }
        else if(unit =="km"){
            meters = _initVal.toDouble() / 1000
        }
        else if(unit =="mm"){
            meters = _initVal.toDouble() * 1000
        }
        else if(unit =="micro-m"){
            meters = _initVal.toDouble() * 1000000
        }
        else if(unit =="nano-m"){
            meters = _initVal.toDouble() * 1000000000
        }
        else if(unit =="ft"){
            meters = (_initVal.toDouble() * 39.37) / 12
        }
        else if(unit =="in"){
            meters = _initVal.toDouble() * 39.37
        }
        else if(unit =="yd"){
            meters = (_initVal.toDouble() * 39.37) / 36

        }
        else if(unit =="mi"){
            meters = (_initVal.toDouble() / 1000) * 0.621
        }
        else if(unit =="angstrom"){
            meters = (_initVal.toDouble() * 39.37) * 4000000000
        }
        return meters
    }

//    fun fromMeters(num: Double): Double{
//        var final = 0.0
//        if(_finalUnit =="cm"){
//            final = num /
//        }
//        else if(_finalUnit =="km"){
//            converted = toMeters("km")
//        }
//        else if(_finalUnit =="mm"){
//            converted = toMeters("mm")
//        }
//        else if(_finalUnit =="micro-m"){
//            converted = toMeters("micro-m")
//        }
//        else if(_finalUnit =="nano-m"){
//            converted = toMeters("nano-m")
//        }
//        else if(_finalUnit =="ft"){
//            converted = toMeters("ft")
//        }
//        else if(_finalUnit =="in"){
//            converted = toMeters("in")
//        }
//        else if(_finalUnit =="yd"){
//            converted = toMeters("yd")
//        }
//        else if(_finalUnit =="mi"){
//            converted = toMeters("mi")
//        }
//        else if(_finalUnit =="angstrom"){
//            converted = toMeters("angstrom")
//        }
//    }

//    fun calculate(): Double{
//        var converted: Double = 0.0
//        if(_initUnit == "m"){
//            if(_finalUnit =="cm"){
//                converted = toMeters("cm")
//            }
//            else if(_finalUnit =="km"){
//                converted = toMeters("km")
//            }
//            else if(_finalUnit =="mm"){
//                converted = toMeters("mm")
//            }
//            else if(_finalUnit =="micro-m"){
//                converted = toMeters("micro-m")
//            }
//            else if(_finalUnit =="nano-m"){
//                converted = toMeters("nano-m")
//            }
//            else if(_finalUnit =="ft"){
//                converted = toMeters("ft")
//            }
//            else if(_finalUnit =="in"){
//                converted = toMeters("in")
//            }
//            else if(_finalUnit =="yd"){
//                converted = toMeters("yd")
//            }
//            else if(_finalUnit =="mi"){
//                converted = toMeters("mi")
//            }
//            else if(_finalUnit =="angstrom"){
//                converted = toMeters("angstrom")
//            }
//        }

//        if(_initUnit == "cm"){
//            if(_finalUnit =="m"){
//
//            }
//            else if(_finalUnit =="km"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="micro-m"){
//
//            }
//            else if(_finalUnit =="nano-m"){
//
//            }
//            else if(_finalUnit =="ft"){
//
//            }
//            else if(_finalUnit =="in"){
//
//            }
//            else if(_finalUnit =="yd"){
//
//            }
//            else if(_finalUnit =="mi"){
//
//            }
//            else if(_finalUnit =="angstrom"){
//
//            }
//        }
//
//        if(_initUnit == "km"){
//            if(_finalUnit =="cm"){
//
//            }
//            else if(_finalUnit =="m"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="micro-m"){
//
//            }
//            else if(_finalUnit =="nano-m"){
//
//            }
//            else if(_finalUnit =="ft"){
//
//            }
//            else if(_finalUnit =="in"){
//
//            }
//            else if(_finalUnit =="yd"){
//
//            }
//            else if(_finalUnit =="mi"){
//
//            }
//            else if(_finalUnit =="angstrom"){
//
//            }
//        }
//
//        if(_initUnit == "mm"){
//            if(_finalUnit =="cm"){
//
//            }
//            else if(_finalUnit =="km"){
//
//            }
//            else if(_finalUnit =="m"){
//
//            }
//            else if(_finalUnit =="micro-m"){
//
//            }
//            else if(_finalUnit =="nano-m"){
//
//            }
//            else if(_finalUnit =="ft"){
//
//            }
//            else if(_finalUnit =="in"){
//
//            }
//            else if(_finalUnit =="yd"){
//
//            }
//            else if(_finalUnit =="mi"){
//
//            }
//            else if(_finalUnit =="angstrom"){
//
//            }
//        }
//        if(_initUnit == "micro-m"){
//            if(_finalUnit =="cm"){
//
//            }
//            else if(_finalUnit =="km"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="m"){
//
//            }
//            else if(_finalUnit =="nano-m"){
//
//            }
//            else if(_finalUnit =="ft"){
//
//            }
//            else if(_finalUnit =="in"){
//
//            }
//            else if(_finalUnit =="yd"){
//
//            }
//            else if(_finalUnit =="mi"){
//
//            }
//            else if(_finalUnit =="angstrom"){
//
//            }
//        }
//
//        if(_initUnit == "nano-m"){
//            if(_finalUnit =="cm"){
//
//            }
//            else if(_finalUnit =="km"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="micro-m"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="ft"){
//
//            }
//            else if(_finalUnit =="in"){
//
//            }
//            else if(_finalUnit =="yd"){
//
//            }
//            else if(_finalUnit =="mi"){
//
//            }
//            else if(_finalUnit =="angstrom"){
//
//            }
//        }
//
//        if(_initUnit == "ft"){
//            if(_finalUnit =="cm"){
//
//            }
//            else if(_finalUnit =="km"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="micro-m"){
//
//            }
//            else if(_finalUnit =="nano-m"){
//
//            }
//            else if(_finalUnit =="m"){
//
//            }
//            else if(_finalUnit =="in"){
//
//            }
//            else if(_finalUnit =="yd"){
//
//            }
//            else if(_finalUnit =="mi"){
//
//            }
//            else if(_finalUnit =="angstrom"){
//
//            }
//        }
//
//        if(_initUnit == "in"){
//            if(_finalUnit =="cm"){
//
//            }
//            else if(_finalUnit =="km"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="micro-m"){
//
//            }
//            else if(_finalUnit =="nano-m"){
//
//            }
//            else if(_finalUnit =="ft"){
//
//            }
//            else if(_finalUnit =="m"){
//
//            }
//            else if(_finalUnit =="yd"){
//
//            }
//            else if(_finalUnit =="mi"){
//
//            }
//            else if(_finalUnit =="angstrom"){
//
//            }
//        }
//
//        if(_initUnit == "yd"){
//            if(_finalUnit =="cm"){
//
//            }
//            else if(_finalUnit =="km"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="micro-m"){
//
//            }
//            else if(_finalUnit =="nano-m"){
//
//            }
//            else if(_finalUnit =="ft"){
//
//            }
//            else if(_finalUnit =="in"){
//
//            }
//            else if(_finalUnit =="m"){
//
//            }
//            else if(_finalUnit =="mi"){
//
//            }
//            else if(_finalUnit =="angstrom"){
//
//            }
//        }
//
//        if(_initUnit == "mi"){
//            if(_finalUnit =="cm"){
//
//            }
//            else if(_finalUnit =="km"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="micro-m"){
//
//            }
//            else if(_finalUnit =="nano-m"){
//
//            }
//            else if(_finalUnit =="ft"){
//
//            }
//            else if(_finalUnit =="in"){
//
//            }
//            else if(_finalUnit =="yd"){
//
//            }
//            else if(_finalUnit =="m"){
//
//            }
//            else if(_finalUnit =="angstrom"){
//
//            }
//        }
//
//        if(_initUnit == "angstrom"){
//            if(_finalUnit =="cm"){
//
//            }
//            else if(_finalUnit =="km"){
//
//            }
//            else if(_finalUnit =="mm"){
//
//            }
//            else if(_finalUnit =="micro-m"){
//
//            }
//            else if(_finalUnit =="nano-m"){
//
//            }
//            else if(_finalUnit =="ft"){
//
//            }
//            else if(_finalUnit =="in"){
//
//            }
//            else if(_finalUnit =="yd"){
//
//            }
//            else if(_finalUnit =="mi"){
//
//            }
//            else if(_finalUnit =="m"){
//
//            }
//        }
        return converted
    }
}