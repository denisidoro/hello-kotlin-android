package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.BuildConfig
import com.github.denisidoro.hellokotlin.core.dagger.DaggerRoboMock
import kotlinx.android.synthetic.main.content_main.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric.setupActivity
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config
import kotlin.test.assertEquals

@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
@RunWith(RobolectricGradleTestRunner::class)
class CounterRoboTest {

    val activity by lazy { setupActivity(CounterActivity::class.java) }

    @Before
    fun before() {
        DaggerRoboMock.setup()
    }

    @Test
    fun bind() {
        with(activity) {

            assertEquals("43 hi", countTV.text);
            plusBT.performClick()
            assertEquals("44 hi", countTV.text);
            for (i in 0..3)
                minusBT.performClick()
            assertEquals("40 hi", countTV.text);

        }
    }

    @Test
    fun apiCall() {
        with(activity) {

            assertEquals("43 hi", countTV.text);
            plusBT.performClick()
            assertEquals("44 hi", userTV.text);
            for (i in 0..3)
                minusBT.performClick()
            assertEquals("40 hi", countTV.text);

        }
    }

}