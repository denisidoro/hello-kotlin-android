package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.Middleware
import com.github.denisidoro.hellokotlin.core.pattern.controller.Controller

class CounterController(activity: CounterActivity) : Controller<CounterState>(activity) {

    override fun getReducer() = CounterReducer()
    override fun getInitialState() = CounterState.initial()
    override fun getMiddlewares(): Array<Middleware<CounterState>> = arrayOf(CounterMiddleware())

    override val selector: CounterSelector = CounterSelector()
    override val view = CounterView(activity, proxy, selector)

    init {
        dispatch(CounterActions.JOKE_REQUEST)
    }

}
