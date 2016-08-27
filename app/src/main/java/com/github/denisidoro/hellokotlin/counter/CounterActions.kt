package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.model.Joke

sealed class CounterActions {
    object INCREMENT
    object DECREMENT
    //data class REQUEST_JOKE(val id: Int)
    data class JOKE_LOADED(val joke: Joke)
}