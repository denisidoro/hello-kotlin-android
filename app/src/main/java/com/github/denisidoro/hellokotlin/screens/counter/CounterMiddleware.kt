package com.github.denisidoro.hellokotlin.screens.counter

import com.beyondeye.reduks.Middleware
import com.beyondeye.reduks.NextDispatcher
import com.beyondeye.reduks.Store
import com.github.denisidoro.hellokotlin.core.dagger.Injector
import com.github.denisidoro.hellokotlin.core.rx.RxScheduler
import com.github.denisidoro.hellokotlin.core.rx.applyScheduler
import com.github.denisidoro.hellokotlin.manager.NorrisManager
import com.github.denisidoro.hellokotlin.screens.counter.CounterActions.JOKE_LOADED
import com.github.denisidoro.hellokotlin.screens.counter.CounterActions.JOKE_REQUEST
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class CounterMiddleware() : Middleware<CounterState> {

    @Inject
    lateinit var norrisManager: NorrisManager
    @Inject
    lateinit var scheduler: RxScheduler

    val subscription = CompositeSubscription()

    init {
        Injector.get().applicationComponent().inject(this)
    }

    override fun dispatch(store: Store<CounterState>, next: NextDispatcher, action: Any?) {
        when (action) {
            is JOKE_REQUEST -> {
                subscription.add(norrisManager.getJoke(store.state.i)
                        .applyScheduler(scheduler)
                        .subscribe { next.dispatch(JOKE_LOADED(it)) })
            }
            else -> next.dispatch(action)
        }
    }

}
