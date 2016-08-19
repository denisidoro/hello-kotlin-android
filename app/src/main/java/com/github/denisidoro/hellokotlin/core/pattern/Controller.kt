package com.github.denisidoro.hellokotlin.core.pattern

import android.os.Bundle
import android.support.annotation.CallSuper
import com.beyondeye.reduks.Reducer
import com.beyondeye.reduks.Reduks
import com.beyondeye.reduks.modules.ReduksContext
import com.beyondeye.reduks.rx.RxStore
import com.beyondeye.reduksAndroid.activity.ActionRestoreState
import rx.subscriptions.CompositeSubscription

abstract class Controller<S>(val activity: BaseActivity<S>) : Reduks<S> {

    val subscription = CompositeSubscription()
    override val ctx = ReduksContext(this.javaClass.name)

    abstract val reducer: Reducer<S>
    abstract val initialState: S
    abstract val view: ViewBinder<S>

    override val store = RxStore(initialState, reducer, subscription)
    override val storeSubscriber = AnvilSubscriber(store)
    override val storeSubscription = store.subscribeRx(storeSubscriber)

    init {
        view.dispatchRequests.subscribe {
            store.dispatch(it)
        }
    }

    @CallSuper
    fun unbind() {
        subscription.unsubscribe()
    }

    fun save(outState: Bundle?) {
        ActionRestoreState.saveReduksState(this, outState)
    }

    fun load(savedState: Bundle?) {
        ActionRestoreState.restoreReduksState(this, savedState)
    }

}
