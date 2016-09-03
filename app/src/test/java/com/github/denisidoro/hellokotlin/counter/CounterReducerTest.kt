package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.model.Joke
import com.github.denisidoro.hellokotlin.model.Value
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CounterReducerTest {

    val reducer = CounterReducer()
    val state = CounterState(3, null)

    @Test
    fun increment() {
        val newState = reducer.reduce(state, CounterActions.INCREMENT)
        assertEquals(4, newState.i)
        assertNull(newState.joke)
    }

    @Test
    fun decrement() {
        val newState = reducer.reduce(state, CounterActions.DECREMENT)
        assertEquals(2, newState.i)
        assertNull(newState.joke)
    }

    @Test
    fun jokeRequested() {
        val joke = Joke(Value(4, "abc"))
        val newState = reducer.reduce(state, CounterActions.JOKE_LOADED(joke))
        assertEquals(joke, newState.joke)
    }

}