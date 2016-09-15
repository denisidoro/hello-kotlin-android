package com.github.denisidoro.hellokotlin.screens.counter

import com.github.denisidoro.hellokotlin.core.Opt
import com.github.denisidoro.hellokotlin.model.Joke

data class CounterState(val i: Int = 45, val joke: Opt<Joke> = Opt<Joke>())