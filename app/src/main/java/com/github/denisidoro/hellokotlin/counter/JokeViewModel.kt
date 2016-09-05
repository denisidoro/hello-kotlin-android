package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.model.Joke

class JokeViewModel(joke: Joke?) {

    val apiText = if (joke != null) joke.value.joke else ""

    val isLoading: Boolean = joke == null

}
