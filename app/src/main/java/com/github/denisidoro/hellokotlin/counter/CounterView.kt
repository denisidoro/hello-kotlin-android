package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.pattern.proxy.Proxy
import com.github.denisidoro.hellokotlin.core.pattern.view.View
import kotlinx.android.synthetic.main.content_main.view.*
import trikita.anvil.Anvil.mount
import trikita.anvil.DSL.text
import trikita.anvil.DSL.xml

class CounterView(override val activity: CounterActivity, proxy: Proxy<CounterState>, override val selector: CounterSelector) : View<CounterState>(activity, proxy, selector) {

    override fun view() {
        xml(R.layout.activity_main) {
            mount(countTV) {
                val counter = subscribe(selector.counter)
                text(counter.counterText)
            }
        }
    }

    /*fun viewT(model: CounterViewModel) {
        xml(R.layout.activity_main) {
            mount(countTV) {
                text(model.counterText)
            }
            mount(plusBT) {
                onClick { v -> dispatch(INCREMENT, JOKE_REQUEST) }
                enabled(!model.isLoading)
            }
            mount(minusBT) {
                onClick { v -> dispatch(DECREMENT, JOKE_REQUEST) }
                enabled(!model.isLoading)
            }
            mount(apiTV) {
                text(model.apiText)
                visibility(!model.isLoading)
            }
            mount(loading) {
                visibility(model.isLoading)
            }
        }
    }*/
}

