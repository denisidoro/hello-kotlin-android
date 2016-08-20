package com.github.denisidoro.hellokotlin.core.pattern

import com.beyondeye.reduks.rx.RxStore
import com.beyondeye.reduks.rx.RxStoreSubscriber
import rx.schedulers.Schedulers
import trikita.anvil.Anvil

class AnvilSubscriber<S>(store: RxStore<S>, val view: ViewBinder<S>) : RxStoreSubscriber<S>(store) {

    init {
        view.dispatchObservable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe { store.dispatch(it) }
    }

    override fun onStateChange(state: S?) {
        view.state = state
        Anvil.render()
    }
}
