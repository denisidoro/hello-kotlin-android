package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.core.pattern.Controller

class CounterController(activity: CounterActivity): Controller<CounterState>(activity) {

    override fun getReducer() = CounterReducer()
    override fun getInitialState() = CounterState(42)
    override val view = CounterViewBinder(activity)

}


