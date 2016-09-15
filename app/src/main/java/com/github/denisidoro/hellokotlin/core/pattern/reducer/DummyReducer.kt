package com.github.denisidoro.hellokotlin.core.pattern.reducer

import com.beyondeye.reduks.Reducer

class DummyReducer<S> : Reducer<S> {
    override fun reduce(state: S, action: Any?): S = state
}
