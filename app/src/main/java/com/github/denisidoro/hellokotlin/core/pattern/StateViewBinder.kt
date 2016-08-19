package com.github.denisidoro.hellokotlin.core.pattern

import rx.Observable

abstract class StateViewBinder<S>(activity: BaseActivity<S>, val stateChanges: Observable<S>) : ViewBinder<S>(activity) {

    override fun view() {
        viewLayout(stateChanges.toBlocking().last())
    }

    abstract fun viewLayout(state: S)

}
