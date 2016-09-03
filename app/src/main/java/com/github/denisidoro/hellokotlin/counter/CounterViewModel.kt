package com.github.denisidoro.hellokotlin.counter

import android.content.Context

class CounterViewModel(context: Context, state: CounterState) {

    val counterText = state.i.toString()

    val apiText = if (state.joke != null) state.joke.value.joke else ""

    val isLoading: Boolean = state.joke == null

}
