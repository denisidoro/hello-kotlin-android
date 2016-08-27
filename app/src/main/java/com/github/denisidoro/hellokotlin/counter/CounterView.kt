package com.github.denisidoro.hellokotlin.counter

import android.support.v7.app.AppCompatActivity
import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.pattern.proxy.ModelProxy
import com.github.denisidoro.hellokotlin.core.pattern.view.ModelView
import kotlinx.android.synthetic.main.content_main.view.*
import trikita.anvil.Anvil.mount
import trikita.anvil.DSL.*

class CounterView(activity: AppCompatActivity, proxy: ModelProxy<CounterViewModel>) : ModelView<CounterViewModel>(activity, proxy) {

    override fun view(model: CounterViewModel) {
        xml(R.layout.activity_main) {
            mount(countTV) {
                text(model.text)
            }
            mount(plusBT) {
                onClick { v -> dispatch(CounterActions.INCREMENT) }
            }
            mount(minusBT) {
                onClick { v -> dispatch(CounterActions.DECREMENT) }
            }
        }
    }
}

