package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.pattern.proxy.ModelProxy
import com.github.denisidoro.hellokotlin.core.pattern.view.ModelView
import kotlinx.android.synthetic.main.content_main.view.*
import trikita.anvil.Anvil
import trikita.anvil.DSL.*

class CounterView(activity: CounterActivity, proxy: ModelProxy<CounterState>) : ModelView<CounterState>(activity, proxy) {

    override fun view(model: CounterState) {
        xml(R.layout.activity_main) {
            Anvil.mount(countTV) {
                text(model.i.toString() + " hi")
            }

            Anvil.mount(plusBT) {
                onClick { v -> dispatch(CounterActions.INCREMENT) }
            }

            Anvil.mount(minusBT) {
                onClick { v -> dispatch(CounterActions.DECREMENT) }
            }
        }
    }
}

