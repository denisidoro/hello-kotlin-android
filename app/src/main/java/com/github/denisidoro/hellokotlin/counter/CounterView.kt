package com.github.denisidoro.hellokotlin.counter

import android.support.v7.app.AppCompatActivity
import com.github.denisidoro.hellokotlin.R
import com.github.denisidoro.hellokotlin.core.pattern.proxy.ModelProxy
import com.github.denisidoro.hellokotlin.core.pattern.view.ModelView
import com.github.denisidoro.hellokotlin.counter.CounterActions.*
import kotlinx.android.synthetic.main.content_main.view.*
import trikita.anvil.Anvil.mount
import trikita.anvil.DSL.*

class CounterView(activity: AppCompatActivity, proxy: ModelProxy<CounterViewModel>) : ModelView<CounterViewModel>(activity, proxy) {

    override fun view(model: CounterViewModel) {
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
    }
}

