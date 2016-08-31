package com.github.denisidoro.hellokotlin.core.dagger.counter

import android.content.Intent
import android.os.SystemClock
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.github.denisidoro.hellokotlin.core.dagger.DaggerEspressoMock
import com.github.denisidoro.hellokotlin.counter.CounterActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CounterActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(CounterActivity::class.java, true, false)
    lateinit var activity: CounterActivity

    @Before
    internal fun before() {
        DaggerEspressoMock.setup()
    }

    @Test
    fun firstTest() {
        givenActivityReady()
        SystemClock.sleep(1010000)
    }

    fun givenActivityReady() {
        val intent = Intent()
        activity = activityRule.launchActivity(intent)
    }

}