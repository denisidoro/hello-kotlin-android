package com.github.denisidoro.hellokotlin.core.rx

import rx.schedulers.TestScheduler

class TestRxScheduler : RxScheduler {

    override val background = TestScheduler()

    override val mainThread = TestScheduler()

}
