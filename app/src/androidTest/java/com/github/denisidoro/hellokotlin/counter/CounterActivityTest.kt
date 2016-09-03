package com.github.denisidoro.hellokotlin.counter

import android.content.Intent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.dagger.DaggerEspressoMock
import com.github.denisidoro.hellokotlin.helpers.EspressoUtils.click
import com.github.denisidoro.hellokotlin.helpers.EspressoUtils.isDisplayed
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
    fun bindings() {
        givenActivityReady()

        isDisplayed("43")
        isDisplayed(R.id.minusBT, R.id.plusBT)

        click(R.id.plusBT)
        isDisplayed("44")
        isDisplayed("mocked joke 44")
    }

    fun givenActivityReady() {
        val intent = Intent()
        activity = activityRule.launchActivity(intent)
    }

}