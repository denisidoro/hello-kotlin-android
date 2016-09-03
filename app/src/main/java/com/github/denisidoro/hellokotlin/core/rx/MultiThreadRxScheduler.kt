package com.github.denisidoro.hellokotlin.core.rx

import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MultiThreadRxScheduler : RxScheduler {

    override val background = Schedulers.io()

    override val mainThread = AndroidSchedulers.mainThread()

}
