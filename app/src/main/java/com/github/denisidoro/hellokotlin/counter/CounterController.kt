package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.rx.RxStore
import com.github.denisidoro.hellokotlin.core.pattern.AnvilSubscriber
import com.github.denisidoro.hellokotlin.core.pattern.Controller
import trikita.anvil.RenderableView

class CounterController(activity: MainActivity): Controller(activity) {

    val reducer = CounterReducer()
    val state = CounterState(42)
    val store = RxStore(state, reducer, subscription)
    val subscriber = AnvilSubscriber(store)

    init {
        store.subscribeRx(subscriber)
    }

    override fun getView(): RenderableView = CounterView(activity, store)

}


