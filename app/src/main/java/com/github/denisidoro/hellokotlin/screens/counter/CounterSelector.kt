package com.github.denisidoro.hellokotlin.screens.counter

import com.beyondeye.reduks.SelectorBuilder

class CounterSelector() {

    val sel = SelectorBuilder<CounterState>()
    val api = sel.withField { joke }.compute { CounterViewModel.Api(it.it) }
    val counter = sel.withField { i }.compute { CounterViewModel.Count(it) }

}