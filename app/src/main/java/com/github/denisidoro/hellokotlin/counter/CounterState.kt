package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.model.Joke

data class CounterState(val i: Int, val joke: Joke?)
