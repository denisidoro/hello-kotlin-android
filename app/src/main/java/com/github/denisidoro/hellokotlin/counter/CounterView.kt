package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.rx.RxStore
import com.github.denisidoro.hellokotlin.core.pattern.BaseActivity
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.content_main.view.*
import trikita.anvil.Anvil.mount
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

class CounterView(private val activity: BaseActivity, private val store: RxStore<CounterState>) : RenderableView(activity) {
    override fun view() {
        xml(com.github.denisidoro.hellokotlin.R.layout.activity_main) {
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

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        activity.setSupportActionBar(toolbar)
    }

}


