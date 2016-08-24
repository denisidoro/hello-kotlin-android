package com.github.denisidoro.hellokotlin.core.pattern.subscriber

import com.beyondeye.reduks.rx.RxStore
import com.beyondeye.reduks.rx.RxStoreSubscriber
import trikita.anvil.Anvil

class AnvilSubscriber<S>(store: RxStore<S>, val beforeRender: () -> Unit) : RxStoreSubscriber<S>(store) {

    constructor(store: RxStore<S>): this(store, {})

    override fun onStateChange(state: S?) {
        beforeRender()
        Anvil.render()
    }

}
