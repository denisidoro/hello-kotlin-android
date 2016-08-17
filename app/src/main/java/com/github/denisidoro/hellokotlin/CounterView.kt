package com.github.denisidoro.hellokotlin

import com.beyondeye.reduks.rx.RxStore
import kotlinx.android.synthetic.main.content_main.view.*
import trikita.anvil.Anvil.mount
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

class CounterView(activity: MainActivity, private val store: RxStore<CounterState>) : RenderableView(activity) {
    override fun view() {
        xml(R.layout.activity_main) {
            mount(countTV) {
                text(store.state.i.toString())
            }

            mount(plusBT) {
                onClick { v -> store.dispatch(CounterActions.INCREMENT) }
            }

            mount(minusBT) {
                onClick { v -> store.dispatch(CounterActions.DECREMENT) }
            }
        }
    }

}


