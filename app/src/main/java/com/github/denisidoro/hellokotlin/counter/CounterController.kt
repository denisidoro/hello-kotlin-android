package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.middlewares.applyMiddleware
import com.beyondeye.reduks.modules.ReduksModule
import com.github.denisidoro.hellokotlin.core.pattern.controller.ModelController

class CounterController(activity: CounterActivity) : ModelController<CounterState, CounterViewModel>(activity) {

    override fun getReducer() = CounterReducer()
    override fun getInitialState() = CounterState(43, null)
    override fun getModel() = CounterViewModel(activity, getState())
    override val view = CounterView(activity, proxy)
    override fun afterReduksSetup(r: ReduksModule<CounterState>) {
        r.store.applyMiddleware(CounterMiddleware(activity))
    }

}


