package com.zmarkan.boundableslider

import android.content.Context
import android.support.v7.widget.AppCompatSeekBar
import android.util.AttributeSet
import android.widget.SeekBar

class BoundableSlider: AppCompatSeekBar {
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context): super(context)

    var calculator: Calculator = Calculator()

    var externalSeekBarChangeListener: OnSeekBarChangeListener? = null
    var valueChangedListener: OnValueChangeListener? = null

    fun configure(minValue: Int, maxValue: Int, stepSize: Int = 1){

        calculator = Calculator(realWorldMin = minValue, realWorldMax = maxValue, realWorldStepSize = stepSize)
        max = calculator.numberOfSteps

        super.setOnSeekBarChangeListener(seekBarChangeListener)
    }

    var seekBarChangeListener: OnSeekBarChangeListener =  (object: OnSeekBarChangeListener {

        var oldProgress: Int = 0

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            externalSeekBarChangeListener?.onStartTrackingTouch(seekBar)
        }

        override fun onProgressChanged(seekBar: SeekBar, progress: Int, isUser: Boolean) {

            val inBoundary = boundary?.inBoundary(progress) ?: true

            if(inBoundary){
                if(oldProgress != progress){
                    oldProgress = progress
                    valueChangedListener?.valueChanged(calculator.getActualValueForProgress(progress))
                }
                externalSeekBarChangeListener?.onProgressChanged(seekBar, progress, isUser)
            }
            else{
                seekBar.progress = boundary!!.value + boundary!!.getStep()
                oldProgress = boundary!!.value + boundary!!.getStep()
            }
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            externalSeekBarChangeListener?.onStopTrackingTouch(seekBar)
        }
    })

    override fun setOnSeekBarChangeListener(l: OnSeekBarChangeListener?) {
        externalSeekBarChangeListener = l
    }

    interface OnValueChangeListener {
        fun valueChanged(newValue: Int)
    }

    var boundary: Boundary? = null

    data class Boundary(val type: BoundaryType, val value: Int)

    fun Boundary.inBoundary(value: Int): Boolean{
        if(this.type.equals(BoundaryType.UPPER))
            return value < this.value
        else return value > this.value
    }

    fun Boundary.getStep(): Int{
        if(this.type.equals(BoundaryType.UPPER)) return -1
        else return 1
    }

    enum class BoundaryType{
        UPPER, LOWER
    }
}