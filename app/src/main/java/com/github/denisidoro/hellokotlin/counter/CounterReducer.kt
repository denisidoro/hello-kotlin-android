package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.Reducer

class CounterReducer : Reducer<CounterState> {
    override fun reduce(state: CounterState, action: Any?) = when (action) {
        is CounterActions.INCREMENT -> state.copy(i = state.i.plus(1))
        is CounterActions.DECREMENT -> state.copy(i = state.i.minus(1))
        else -> state
    }
}
