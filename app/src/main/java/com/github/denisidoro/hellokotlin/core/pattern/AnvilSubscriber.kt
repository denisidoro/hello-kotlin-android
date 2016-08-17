package com.github.denisidoro.hellokotlin.core.pattern

import com.beyondeye.reduks.rx.RxStore
import com.beyondeye.reduks.rx.RxStoreSubscriber
import trikita.anvil.Anvil

class AnvilSubscriber<S>(store: RxStore<S>) : RxStoreSubscriber<S>(store) {
    override fun onStateChange(state: S?) {
        Anvil.render()
    }
}
