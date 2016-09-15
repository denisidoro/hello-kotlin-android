package com.github.denisidoro.hellokotlin.screens.counter

import com.beyondeye.reduks.Store
import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.pattern.view.View
import com.github.denisidoro.hellokotlin.screens.counter.CounterActions.*
import trikita.anvil.DSL.*

class CounterView(override val activity: CounterActivity, store: Store<CounterState>, override val selector: CounterSelector) : View<CounterState>(activity, store, selector) {

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
        val apiModel = defer(selector.api)
        withId(R.id.plusBT) {
            onClick { v -> dispatch(INCREMENT, JOKE_REQUEST) }
            enabled(!apiModel.isLoading)
        }
        withId(R.id.minusBT) {
            onClick { v -> dispatch(DECREMENT, JOKE_REQUEST) }
            enabled(!apiModel.isLoading)
        }

    }

    fun result() {
        val apiModel = defer(selector.api)
        withId(R.id.apiTV) {
            text(apiModel.apiText)
            visibility(!apiModel.isLoading)
        }
        withId(R.id.loading) {
            visibility(apiModel.isLoading)
        }
    }

}

