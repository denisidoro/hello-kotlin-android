package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.Middleware
import com.beyondeye.reduks.NextDispatcher
import com.beyondeye.reduks.Store
import com.github.denisidoro.hellokotlin.core.dagger.Injector
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity
import com.github.denisidoro.hellokotlin.counter.CounterActions.JOKE_LOADED
import com.github.denisidoro.hellokotlin.counter.CounterActions.JOKE_REQUEST
import com.github.denisidoro.hellokotlin.provider.NorrisProvider
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class CounterMiddleware(activity: BaseActivity<CounterState>) : Middleware<CounterState> {

    @Inject
    lateinit var norrisProvider: NorrisProvider

    val subscription = CompositeSubscription()

    init {
        Injector.get().activityComponent(activity).inject(this)
    }

    override fun dispatch(store: Store<CounterState>, next: NextDispatcher, action: Any?) {
        when (action) {
            is JOKE_REQUEST -> {
                subscription.add(norrisProvider.getJoke(store.state.i)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { next.dispatch(JOKE_LOADED(it)) })
            }
            else -> next.dispatch(action)
        }
    }

}
