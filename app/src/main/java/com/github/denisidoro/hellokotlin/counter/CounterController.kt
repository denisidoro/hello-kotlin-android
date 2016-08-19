package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.core.pattern.Controller

class CounterController(activity: CounterActivity): Controller<CounterState>(activity) {

    override val reducer = CounterReducer()
    override val initialState = CounterState(42)
    override val view = CounterView(activity, store.stateChanges)

}


