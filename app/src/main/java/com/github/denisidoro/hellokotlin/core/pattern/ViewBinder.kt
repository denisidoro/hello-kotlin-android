package com.github.denisidoro.hellokotlin.core.pattern

import com.beyondeye.reduks.rx.RxStore
import trikita.anvil.RenderableView

abstract class ViewBinder<S>(activity: BaseActivity<S>, private val store: RxStore<S>) : RenderableView(activity) {

    fun getState() = store.state

    protected fun dispatch(action: Action) {
        store.dispatch(action)
    }

}
