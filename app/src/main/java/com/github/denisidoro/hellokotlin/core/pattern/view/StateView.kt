package com.github.denisidoro.hellokotlin.core.pattern.view

import com.beyondeye.reduks.Store
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity

abstract class StateView<S>(activity: BaseActivity<S>, store: Store<S>) : View<S>(activity, store) {

    override fun view() {
        view(getState())
    }

    abstract fun view(state: S)

}