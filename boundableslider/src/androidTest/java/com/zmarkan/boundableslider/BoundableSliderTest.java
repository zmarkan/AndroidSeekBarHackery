package com.zmarkan.boundableslider;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.RelativeLayout;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.*;

@RunWith(AndroidJUnit4.class)
public class BoundableSliderTest {

    @Rule
    public ActivityTestRule<TestActivity> activityTestRule = new ActivityTestRule<TestActivity>(TestActivity.class);

    BoundableSlider slider;

    @Before
    public void setUp() throws Throwable {

        slider = (BoundableSlider) activityTestRule.getActivity().findViewById(R.id.slider);
    }

    @Test
    public void sliderCreated() throws InterruptedException {
        assertNotNull(slider);
        assertEquals(100,slider.getMaxValue());
    }

    @Test
    public void configure(){
        onView(withId(R.id.slider)).check(matches(isDisplayed()));

        slider.configure(20, 100, 5);
        assertEquals(20, slider.getMinValue());
        assertEquals(100, slider.getMaxValue());
        assertEquals(5, slider.getStepSize());

        slider.configure(150, 2000, 17);
        assertEquals(150, slider.getMinValue());
        assertEquals(2000, slider.getMaxValue());
        assertEquals(17, slider.getStepSize());
    }

//    @Test
//    fun configure(){
//

//    }
//
//    @Test
//    fun calculateNumberOfSteps(){
//
//        slider.configure(20, 100, 5)
//        assertEquals(16, slider.numSteps())
//    }
//
//    @Test
//    fun currentValue_whenProgressIs0(){
//
//        slider.configure(20, 100, 5)
//        slider.progress = 0
//        assertEquals(20, slider.getCurrentValue())
//    }
//
//    @Test
//    fun currentValue_whenProgressIs1000(){
//
//        slider.configure(20, 100, 5)
//        slider.progress = 6
//        assertEquals(20, slider.getCurrentValue())
//    }

//    @Test
//    fun currentValue_whenProgressIsMax(){
//        slider.configure(20, 100, 5)
//        slider.progress = 20
//        assertEquals(100, slider.getCurrentValue())
//    }




}