package com.github.denisidoro.hellokotlin.core.rx

import rx.schedulers.TestScheduler
import java.util.concurrent.TimeUnit

class TestRxScheduler : RxScheduler {

    val scheduler: TestScheduler = TestScheduler()

    override val background = scheduler

    override val mainThread = scheduler

    fun advanceTime() {
        scheduler.advanceTimeBy(10, TimeUnit.SECONDS)
        scheduler.triggerActions()
    }

    fun advanceTimeBy(time: Long, unit: TimeUnit) {
        scheduler.advanceTimeBy(time, unit)
        scheduler.triggerActions()
    }

}
