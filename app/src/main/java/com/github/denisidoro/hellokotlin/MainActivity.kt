package com.github.denisidoro.hellokotlin

import android.os.Bundle
import com.beyondeye.reduks.rx.RxStore
import com.github.denisidoro.hellokotlin.core.pattern.AnvilSubscriber
import com.github.denisidoro.hellokotlin.core.pattern.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import rx.subscriptions.CompositeSubscription

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val subscription = CompositeSubscription()
        val reducer = CounterReducer()
        val state = CounterState(42)
        val store = RxStore(state, reducer, subscription)

        setContentView(CounterView(this, store))

        val subscriber = AnvilSubscriber(store)
        store.subscribeRx(subscriber)

        setSupportActionBar(toolbar)
    }

}





