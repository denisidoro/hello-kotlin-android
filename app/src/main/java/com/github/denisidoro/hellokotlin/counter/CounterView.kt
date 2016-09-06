package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.pattern.proxy.Proxy
import com.github.denisidoro.hellokotlin.core.pattern.view.View
import com.github.denisidoro.hellokotlin.counter.CounterActions.*
import trikita.anvil.DSL.*

class CounterView(override val activity: CounterActivity, proxy: Proxy<CounterState>, override val selector: CounterSelector) : View<CounterState>(activity, proxy, selector) {

    override fun view() {
        xml(R.layout.activity_main) {
            counter()
            buttons()
            result()
        }
    }

    fun counter() {
        withId(R.id.countTV) {
            val counter = defer(selector.counter)
            text(counter.counterText)
        }
    }

    fun buttons() {
        val viewModel = defer(selector.joke)
        withId(R.id.plusBT) {
            onClick { v -> dispatch(INCREMENT, JOKE_REQUEST) }
            enabled(!viewModel.isLoading)
        }
        withId(R.id.minusBT) {
            onClick { v -> dispatch(DECREMENT, JOKE_REQUEST) }
            enabled(!viewModel.isLoading)
        }

    }

    fun result() {
        val viewModel = defer(selector.joke)
        withId(R.id.apiTV) {
            text(viewModel.apiText)
            visibility(!viewModel.isLoading)
        }
        withId(R.id.loading) {
            visibility(viewModel.isLoading)
        }
    }

}

