package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.SelectorBuilder

class CounterSelector() {

    val sel = SelectorBuilder<CounterState>()
    val joke = sel.withField { joke }.compute { CounterViewModel.Api(it.it) }
    val counter = sel.withField { i }.compute { CounterViewModel.Count(it) }

}
