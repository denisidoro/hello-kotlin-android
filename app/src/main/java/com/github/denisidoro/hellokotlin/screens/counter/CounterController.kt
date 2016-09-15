package com.github.denisidoro.hellokotlin.screens.counter

import com.beyondeye.reduks.Middleware
import com.github.denisidoro.hellokotlin.core.pattern.controller.Controller

class CounterController(activity: CounterActivity) : Controller<CounterState>(activity) {

    override fun getReducer() = CounterReducer()
    override fun getInitialState() = CounterState()
    override fun getMiddlewares(): Array<Middleware<CounterState>> = arrayOf(CounterMiddleware())

    override val selector: CounterSelector = CounterSelector()
    override val view by lazy { CounterView(activity, store, selector) }

    init {
        store.dispatch(CounterActions.JOKE_REQUEST)
    }

}
