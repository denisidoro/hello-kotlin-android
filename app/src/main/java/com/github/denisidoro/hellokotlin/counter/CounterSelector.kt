package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.SelectorBuilder

class CounterSelector() {

    val sel = SelectorBuilder<CounterState>()
    val joke = sel.withSingleField { joke!! }
    val counter = sel.withField { i }.compute { CounterViewModel(it) }

}
