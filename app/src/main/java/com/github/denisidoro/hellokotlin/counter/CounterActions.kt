package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.model.Joke

sealed class CounterActions {
    object INCREMENT
    object DECREMENT
    object JOKE_REQUEST
    data class JOKE_LOADED(val joke: Joke)
}