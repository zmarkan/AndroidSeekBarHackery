package com.zmarkan.boundableslider

class Calculator(var realWorldMin: Int = 0, var realWorldMax: Int = 100, var realWorldStepSize: Int = 1) {

    val numberOfSteps = (realWorldMax - realWorldMin )/ realWorldStepSize.toInt()

    fun getActualValueForProgress(progress: Int): Int {
        return progress * realWorldStepSize + realWorldMin
    }
}




