package com.github.denisidoro.hellokotlin.counter

import android.content.Context
import com.github.denisidoro.hellokotlin.R

class CounterViewModel(context: Context, state: CounterState) {

    val counterText = state.i.toString() + " " + context.getString(R.string.hello)

    val apiText = if (state.joke != null) state.joke.value.joke else ""

}
