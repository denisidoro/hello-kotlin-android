package com.github.denisidoro.hellokotlin.counter

import android.util.Log
import com.github.denisidoro.hellokotlin.core.dagger.Injector
import com.github.denisidoro.hellokotlin.core.pattern.controller.ModelController
import com.github.denisidoro.hellokotlin.provider.NorrisProvider
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class CounterController(activity: CounterActivity) : ModelController<CounterState, CounterViewModel>(activity) {

    @Inject
    lateinit var norrisProvider: NorrisProvider

    init {
        Injector.get().activityComponent(activity).inject(this)
        norrisProvider.getJoke(15)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { Log.e("api sucess", it.toString()); dispatch(CounterActions.JOKE_LOADED(it)) },
                        { Log.e("api error", it.message) })
    }

    override fun getReducer() = CounterReducer()
    override fun getInitialState() = CounterState(43, null)
    override fun getModel() = CounterViewModel(activity, getState())
    override val view = CounterView(activity, proxy)


}


