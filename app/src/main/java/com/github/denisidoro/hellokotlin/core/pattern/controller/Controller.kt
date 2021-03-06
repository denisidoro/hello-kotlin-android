package com.github.denisidoro.hellokotlin.core.pattern.controller

import android.os.Bundle
import android.support.annotation.CallSuper
import com.beyondeye.reduks.Middleware
import com.beyondeye.reduks.Reducer
import com.beyondeye.reduks.Reduks
import com.beyondeye.reduks.StoreSubscriberBuilder
import com.beyondeye.reduks.middlewares.applyMiddleware
import com.beyondeye.reduks.modules.ReduksContext
import com.beyondeye.reduks.modules.ReduksModule
import com.beyondeye.reduks.rx.RxStore
import com.beyondeye.reduks.rx.RxStoreSubscriber
import com.beyondeye.reduksAndroid.activity.ActionRestoreState
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity
import com.github.denisidoro.hellokotlin.core.pattern.proxy.Proxy
import com.github.denisidoro.hellokotlin.core.pattern.subscriber.AnvilSubscriber
import com.github.denisidoro.hellokotlin.core.pattern.view.View
import rx.subscriptions.CompositeSubscription

abstract class Controller<S>(val activity: BaseActivity<S>) {

    val subscription = CompositeSubscription()

    abstract fun getReducer(): Reducer<S>
    abstract fun getInitialState(): S
    protected fun getStoreSubscriber(store: RxStore<S>): RxStoreSubscriber<S> = AnvilSubscriber(store)
    open fun getMiddlewares(): Array<Middleware<S>> = arrayOf()

    protected val reduks: Reduks<S> by lazy {
        val ctx = ReduksContext(this.javaClass.name)
        val r = ReduksModule<S>(ReduksModule.Def<S>(
                ctx,
                RxStore.Factory<S>(subscription),
                getInitialState(),
                ctx,
                getReducer(),
                StoreSubscriberBuilder<S> { getStoreSubscriber(it as RxStore<S>) }))
        val m = getMiddlewares()
        if (m.size > 0) {
            r.store.applyMiddleware(*m)
        }
        r
    }

    val getState: () -> S = { reduks.store.state }
    val dispatch by lazy { reduks.store.dispatch }

    open val proxy: Proxy by lazy { Proxy(dispatch) }
    abstract val view: View

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
