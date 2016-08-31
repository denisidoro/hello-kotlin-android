package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.Reducer
import com.github.denisidoro.hellokotlin.counter.CounterActions.*

class CounterReducer : Reducer<CounterState> {
    override fun reduce(state: CounterState, action: Any?) = when (action) {
        is INCREMENT -> state.copy(i = state.i.plus(1), joke = null)
        is DECREMENT -> state.copy(i = state.i.minus(1), joke = null)
        is JOKE_LOADED -> state.copy(joke = action.joke)
        else -> state
    }
}
