package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.Middleware
import com.github.denisidoro.hellokotlin.core.pattern.controller.ModelController

class
CounterController(activity: CounterActivity) : ModelController<CounterState, CounterViewModel>(activity) {

    override fun getReducer() = CounterReducer()
    override fun getInitialState() = CounterState(43, null)
    override fun getModel() = CounterViewModel(activity, getState())
    override fun getMiddlewares(): Array<Middleware<CounterState>> = arrayOf(CounterMiddleware(activity))
    override val view = CounterView(activity, proxy)

    init {
        dispatch(CounterActions.JOKE_REQUEST)
    }

}
