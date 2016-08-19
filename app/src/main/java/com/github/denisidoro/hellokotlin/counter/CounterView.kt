package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.pattern.StateViewBinder
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.content_main.view.*
import rx.Observable
import trikita.anvil.Anvil
import trikita.anvil.DSL
import trikita.anvil.DSL.text
import trikita.anvil.DSL.xml

class CounterView(activity: CounterActivity, stateChanges: Observable<CounterState>) : StateViewBinder<CounterState>(activity, stateChanges) {

    override fun viewLayout(state: CounterState) {
        xml(R.layout.activity_main) {
            Anvil.mount(countTV) {
                text(state.i.toString())
            }

            Anvil.mount(plusBT) {
                DSL.onClick { v -> requestAction(CounterActions.INCREMENT) }
            }

            Anvil.mount(minusBT) {
                DSL.onClick { v -> requestAction(CounterActions.DECREMENT) }
            }
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        activity.setSupportActionBar(toolbar)
    }

}


