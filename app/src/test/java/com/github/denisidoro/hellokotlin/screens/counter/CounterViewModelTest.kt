package com.github.denisidoro.hellokotlin.screens.counter

import com.github.denisidoro.hellokotlin.BuildConfig
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.annotation.Config

@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
@RunWith(RobolectricGradleTestRunner::class)
class CounterViewModelTest {

    /*@Test
    fun testGetText() {
        val viewModel = CounterViewModel(application, CounterState(33, null))
        assertEquals("33", viewModel.counterText)
    }*/
}