package com.zmarkan.pricefilterspike

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.SeekBar
import com.zmarkan.boundableslider.BoundableSlider
import timber.log.Timber

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        val minSlider = findViewById(R.id.slider1) as BoundableSlider
        val maxSlider = findViewById(R.id.slider2) as BoundableSlider

        minSlider.configure(20, 300, 30)
//        minSlider.boundary = (BoundableSlider.Boundary(BoundableSlider.BoundaryType.UPPER, 7))
        maxSlider.configure(20, 300, 30)
        maxSlider.progress = maxSlider.max

        minSlider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(p0: SeekBar, p1: Int, p2: Boolean) {}
            override fun onStartTrackingTouch(p0: SeekBar) {}
            override fun onStopTrackingTouch(p0: SeekBar) {
                maxSlider.boundary = BoundableSlider.Boundary(BoundableSlider.BoundaryType.LOWER, p0.progress)
            }
        })

        maxSlider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar, p1: Int, p2: Boolean) {}
            override fun onStartTrackingTouch(p0: SeekBar) {}
            override fun onStopTrackingTouch(p0: SeekBar) {
                minSlider.boundary = BoundableSlider.Boundary(BoundableSlider.BoundaryType.UPPER, p0.progress)
            }
        })


        minSlider.valueChangedListener = (object: BoundableSlider.OnValueChangeListener{
            override fun valueChanged(newValue: Int) {

                Timber.d("ValueChanged %d", newValue)
            }

        })
    }

}
