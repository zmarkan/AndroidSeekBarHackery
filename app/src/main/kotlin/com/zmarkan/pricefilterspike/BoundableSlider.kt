package com.zmarkan.pricefilterspike

import android.content.Context
import android.support.v7.widget.AppCompatSeekBar
import android.util.AttributeSet

class BoundableSlider: AppCompatSeekBar{
//    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet ): super(context, attrs)
    constructor(context: Context): super(context)


}