package com.github.denisidoro.hellokotlin.core.rx

import rx.Completable
import rx.Observable
import rx.Scheduler
import rx.Single

interface RxScheduler {

    val background: Scheduler

    val mainThread: Scheduler

}

fun <T> Observable<T>.applyScheduler(scheduler: RxScheduler) = compose({ observable ->
    observable
            .subscribeOn(scheduler.background)
            .observeOn(scheduler.mainThread)
            .doOnError { throwable -> throwable.printStackTrace() }
})


fun <T> Single<T>.applyScheduler(scheduler: RxScheduler) = compose({ single ->
    single
            .subscribeOn(scheduler.background)
            .observeOn(scheduler.mainThread)
            .doOnError { throwable -> throwable.printStackTrace() }
})

fun Completable.applyScheduler(scheduler: RxScheduler) = compose({ completable ->
    completable
            .subscribeOn(scheduler.background)
            .observeOn(scheduler.mainThread)
            .doOnError { throwable -> throwable.printStackTrace() }
})
