package com.zmarkan.pricefilterspike

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import timber.log.Timber

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        val slider1 = findViewById(R.id.slider1) as BoundableSlider
        val slider2 = findViewById(R.id.slider2) as BoundableSlider

        slider1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Timber.d("onStartTrackingTouch")
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, isUser: Boolean) {

                if(progress <= 20){
                    slider1.progress = 20
                }
                Timber.d("OnProgressChanged %d", progress)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Timber.d("onStopTrackingTouch")
            }


        })

        slider2.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: SeekBar) {
                Timber.d("onStartTrackingTouch")
            }

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, isUser: Boolean) {

                if(progress >= 86){
                    slider2.progress = 86
                }
                Timber.d("OnProgressChanged %d", progress)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                Timber.d("onStopTrackingTouch")
            }
        })


    }

}
