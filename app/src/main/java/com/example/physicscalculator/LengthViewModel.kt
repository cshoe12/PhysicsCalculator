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

    fun calculate(){
        if(_initUnit == "m"){
            if(_finalUnit =="cm"){

            }
            else if(_finalUnit =="km"){

            }
            else if(_finalUnit =="mm"){

            }
            else if(_finalUnit =="micro-m"){

            }
            else if(_finalUnit =="nano-m"){

            }
            else if(_finalUnit =="ft"){

            }
            else if(_finalUnit =="in"){

            }
            else if(_finalUnit =="yd"){

            }
            else if(_finalUnit =="mi"){

            }
            else if(_finalUnit =="angstrom"){

            }
        }

        if(_initUnit == "cm"){
            if(_finalUnit =="m"){

            }
            else if(_finalUnit =="km"){

            }
            else if(_finalUnit =="mm"){

            }
            else if(_finalUnit =="micro-m"){

            }
            else if(_finalUnit =="nano-m"){

            }
            else if(_finalUnit =="ft"){

            }
            else if(_finalUnit =="in"){

            }
            else if(_finalUnit =="yd"){

            }
            else if(_finalUnit =="mi"){

            }
            else if(_finalUnit =="angstrom"){

            }
        }

        if(_initUnit == "km"){
            if(_finalUnit =="cm"){

            }
            else if(_finalUnit =="m"){

            }
            else if(_finalUnit =="mm"){

            }
            else if(_finalUnit =="micro-m"){

            }
            else if(_finalUnit =="nano-m"){

            }
            else if(_finalUnit =="ft"){

            }
            else if(_finalUnit =="in"){

            }
            else if(_finalUnit =="yd"){

            }
            else if(_finalUnit =="mi"){

            }
            else if(_finalUnit =="angstrom"){

            }
        }

        if(_initUnit == "mm"){
            if(_finalUnit =="cm"){

            }
            else if(_finalUnit =="km"){

            }
            else if(_finalUnit =="m"){

            }
            else if(_finalUnit =="micro-m"){

            }
            else if(_finalUnit =="nano-m"){

            }
            else if(_finalUnit =="ft"){

            }
            else if(_finalUnit =="in"){

            }
            else if(_finalUnit =="yd"){

            }
            else if(_finalUnit =="mi"){

            }
            else if(_finalUnit =="angstrom"){

            }
        }
    }
}