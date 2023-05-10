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

    fun calculate(): Double{
        var converted: Double = 0.0
        if(_initUnit == "m"){
            if(_finalUnit =="cm"){
                converted = _initVal.toDouble() * 100
            }
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
        }

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