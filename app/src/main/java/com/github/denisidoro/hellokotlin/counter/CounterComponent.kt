package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.core.pattern.Component

class CounterComponent(activity: CounterActivity): Component<CounterState>(activity) {

    override fun getReducer() = CounterReducer()
    override fun getInitialState() = CounterState(42)
    override val view = CounterView(activity, reduks.store)

}


