package com.github.denisidoro.hellokotlin.screens.counter

import com.beyondeye.reduks.Reducer
import com.github.denisidoro.hellokotlin.core.Opt
import com.github.denisidoro.hellokotlin.model.Joke
import com.github.denisidoro.hellokotlin.screens.counter.CounterActions.*

class CounterReducer : Reducer<CounterState> {
    override fun reduce(state: CounterState, action: Any?) =
            when (action) {
                is INCREMENT -> state.copy(i = state.i.plus(1), joke = Opt<Joke>())
                is DECREMENT -> state.copy(i = state.i.minus(1), joke = Opt<Joke>())
                is JOKE_LOADED -> state.copy(joke = Opt(action.joke))
                else -> state
            }
}
