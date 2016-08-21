package com.github.denisidoro.hellokotlin.core.pattern

import com.beyondeye.reduks.Store

abstract class StateView<S>(activity: BaseActivity<S>, store: Store<S>) : View<S>(activity, store) {

    override fun view() {
        view(getState())
    }

    abstract fun view(state: S)

}