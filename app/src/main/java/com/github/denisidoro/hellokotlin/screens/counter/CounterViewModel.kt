package com.github.denisidoro.hellokotlin.screens.counter

import com.github.denisidoro.hellokotlin.model.Joke

class CounterViewModel {

    class Count(i: Int) {
        val counterText = i.toString()
    }

    class Api(val joke: Joke?) {
        val apiText = joke?.value?.text ?: ""
        val isLoading: Boolean = joke == null
    }

}
