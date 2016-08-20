package com.github.denisidoro.hellokotlin.core.pattern

import com.beyondeye.reduks.rx.RxStore

abstract class StateViewBinder<S>(activity: BaseActivity<S>, store: RxStore<S>) : ViewBinder<S>(activity, store) {

    override fun view() {
        viewByState(getState())
    }

    abstract fun viewByState(state: S)

}
