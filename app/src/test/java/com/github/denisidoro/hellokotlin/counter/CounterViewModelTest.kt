package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.BuildConfig
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricGradleTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import kotlin.test.assertEquals

@Config(constants = BuildConfig::class, sdk = intArrayOf(21))
@RunWith(RobolectricGradleTestRunner::class)
class CounterViewModelTest {

    @Test
    fun testGetText() {
        val viewModel = CounterViewModel(RuntimeEnvironment.application, 44)
        assertEquals("44 hi", viewModel.text)
    }
}