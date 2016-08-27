package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.core.pattern.controller.ModelController

class CounterController(activity: CounterActivity): ModelController<CounterState, CounterViewModel>(activity) {

    override fun getReducer() = CounterReducer()
    override fun getInitialState() = CounterState(43)
    override fun getModel() = CounterViewModel(activity, getState().i)
    override val view = CounterView(activity, proxy)

}


