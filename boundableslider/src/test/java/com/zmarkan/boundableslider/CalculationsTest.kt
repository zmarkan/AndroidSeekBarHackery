package com.zmarkan.boundableslider

import android.content.Context
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.*


class CalculationsTest {

    @Test
    fun testThatPasses(){
        assertTrue(true)
    }

    @Test
    fun testThatFails(){
        assertTrue(false)
    }

    @Test
    fun determineProgress(){
        val min = 20
        val max = 500
        val stepSize = 5

        val calc = Calculator(min, max, stepSize)

        assertEquals(min, calc.determineProgress(0))
        assertEquals(max, calc.determineProgress(10000))
        assertEquals(240, calc.determineProgress(5000))

    }





}