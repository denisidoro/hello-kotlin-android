package com.github.denisidoro.hellokotlin.core.pattern

import android.os.Bundle
import android.support.annotation.CallSuper
import com.beyondeye.reduks.Reducer
import com.beyondeye.reduks.Reduks
import com.beyondeye.reduks.modules.ReduksContext
import com.beyondeye.reduks.rx.RxStore
import com.beyondeye.reduksAndroid.activity.ActionRestoreState
import rx.subscriptions.CompositeSubscription
import trikita.anvil.RenderableView

abstract class Controller<S>(protected val activity: BaseActivity<S>) : Reduks<S> {

    val subscription = CompositeSubscription()
    override val ctx = ReduksContext(this.javaClass.name)

    abstract val reducer: Reducer<S>
    abstract val state: S
    abstract val view: RenderableView

    override val store = RxStore(state, reducer, subscription)
    override val storeSubscriber = AnvilSubscriber(store)
    override val storeSubscription = store.subscribeRx(storeSubscriber)

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
