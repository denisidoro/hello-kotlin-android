package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.Store
import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.pattern.StateView
import kotlinx.android.synthetic.main.content_main.view.*
import trikita.anvil.Anvil
import trikita.anvil.DSL.*

class CounterView(activity: CounterActivity, store: Store<CounterState>) : StateView<CounterState>(activity, store) {

    override fun view(state: CounterState) {
        xml(R.layout.activity_main) {
            Anvil.mount(countTV) {
                text(state.i.toString())
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


