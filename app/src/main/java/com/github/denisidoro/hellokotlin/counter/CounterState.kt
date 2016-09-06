package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.core.Opt
import com.github.denisidoro.hellokotlin.model.Joke

data class CounterState(val i: Int, val joke: Opt<Joke>) {

    companion object {
        fun initial() = CounterState(43, Opt<Joke>())
    }

}
