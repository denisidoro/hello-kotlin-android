package com.github.denisidoro.hellokotlin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.beyondeye.reduks.Reducer
import com.beyondeye.reduks.rx.RxStore
import com.beyondeye.reduks.rx.RxStoreSubscriber
import com.github.denisidoro.hellokotlin.core.pattern.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.view.*
import rx.subscriptions.CompositeSubscription
import trikita.anvil.Anvil
import trikita.anvil.Anvil.mount
import trikita.anvil.DSL.*
import trikita.anvil.RenderableView

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val subscription = CompositeSubscription()
        val reducer = Reducer<CounterState> { state, action ->
            when (action) {
                is CounterActions.INCREMENT -> state.copy(i = state.i.plus(1))
                is CounterActions.DECREMENT -> state.copy(i = state.i.minus(1))
                else -> state
            }
        }
        val state = CounterState(42)
        val store = RxStore(state, reducer, subscription)

        setContentView(MyRenderableView(this, store))

        val subscriber = CounterStoreSubscriber(store)
        store.subscribeRx(subscriber)

        setSupportActionBar(toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}

class MyRenderableView(activity: MainActivity, private val store: RxStore<CounterState>) : RenderableView(activity) {
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

class CounterStoreSubscriber(store: RxStore<CounterState>) : RxStoreSubscriber<CounterState>(store) {
    override fun onStateChange(state: CounterState?) {
        Anvil.render()
    }
}



