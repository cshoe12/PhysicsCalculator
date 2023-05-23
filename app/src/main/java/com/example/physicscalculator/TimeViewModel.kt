package com.example.physicscalculator

import androidx.lifecycle.ViewModel

class TimeViewModel: ViewModel() {

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

    fun calculate(): Double {
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
            var convertedSec = toSeconds("nano-s", _initVal.toDouble())

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
            var convertedSec = toSeconds("hour", _initVal.toDouble())

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
}