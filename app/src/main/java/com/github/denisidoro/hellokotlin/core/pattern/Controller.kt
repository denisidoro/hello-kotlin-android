package com.github.denisidoro.hellokotlin.core.pattern

import android.os.Bundle
import android.support.annotation.CallSuper
import com.beyondeye.reduks.Reducer
import com.beyondeye.reduks.Reduks
import com.beyondeye.reduks.StoreSubscriberBuilder
import com.beyondeye.reduks.modules.ReduksContext
import com.beyondeye.reduks.modules.ReduksModule
import com.beyondeye.reduks.rx.RxStore
import com.beyondeye.reduks.rx.RxStoreSubscriber
import com.beyondeye.reduksAndroid.activity.ActionRestoreState
import rx.subscriptions.CompositeSubscription

abstract class Controller<S>(val activity: BaseActivity<S>) {

    val subscription = CompositeSubscription()

    abstract fun getReducer(): Reducer<S>
    abstract fun getInitialState(): S
    abstract val view: ViewBinder<S>

    val reduks: Reduks<S> by lazy {
        ReduksModule<S>(ReduksModule.Def<S>(
                ReduksContext(this.javaClass.name),
                RxStore.Factory<S>(subscription),
                getInitialState(),
                START,
                getReducer(),
                StoreSubscriberBuilder<S> { getStoreSubscriber(it as RxStore<S>) }))
    }

    protected fun getStoreSubscriber(store: RxStore<S>): RxStoreSubscriber<S> = AnvilSubscriber(store, view)

    @CallSuper
    fun unbind() {
        subscription.unsubscribe()
    }

    fun save(outState: Bundle?) {
        ActionRestoreState.saveReduksState(reduks, outState)
    }

    fun load(savedState: Bundle?) {
        ActionRestoreState.restoreReduksState(reduks, savedState)
    }

}
