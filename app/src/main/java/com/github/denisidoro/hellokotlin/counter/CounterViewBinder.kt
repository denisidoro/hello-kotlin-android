package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.pattern.ViewBinder
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.content_main.view.*
import trikita.anvil.Anvil
import trikita.anvil.DSL
import trikita.anvil.DSL.text
import trikita.anvil.DSL.xml

class CounterViewBinder(val activity: CounterActivity) : ViewBinder<CounterState>(activity) {

    override fun viewFromState(state: CounterState) {
        xml(R.layout.activity_main) {
            Anvil.mount(countTV) {
                text(state.i.toString())
            }

            Anvil.mount(plusBT) {
                DSL.onClick { v -> dispatch(CounterActions.INCREMENT) }
            }

            Anvil.mount(minusBT) {
                DSL.onClick { v -> dispatch(CounterActions.DECREMENT) }
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        activity.setSupportActionBar(toolbar)
    }

}


