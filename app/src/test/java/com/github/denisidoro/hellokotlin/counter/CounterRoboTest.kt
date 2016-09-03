package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.BuildConfig
import com.github.denisidoro.hellokotlin.core.dagger.DaggerMock
import com.github.denisidoro.hellokotlin.core.dagger.providers.RoboApplicationProvider
import com.github.denisidoro.hellokotlin.core.rx.TestRxScheduler
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
    val scheduler = TestRxScheduler()

    @Before
    fun before() {
        DaggerMock.setup(object: RoboApplicationProvider() {
            override fun provideRxScheduler() = scheduler
        })
    }

    @Test
    fun bind() {
        with(activity) {
            scheduler.advanceTime()
            assertEquals("43", countTV.text)
            assertEquals("mocked joke 43", apiTV.text)

            plusBT.performClick()
            scheduler.advanceTime()
            assertEquals("44", countTV.text)
            assertEquals("mocked joke 44", apiTV.text)

            for (i in 0..3)
                minusBT.performClick()
            scheduler.advanceTime()
            assertEquals("40", countTV.text)
            assertEquals("mocked joke 40", apiTV.text)
        }
    }


}