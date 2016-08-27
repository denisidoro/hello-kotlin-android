package com.github.denisidoro.hellokotlin.counter

import org.junit.Test
import kotlin.test.assertEquals

class CounterReducerTest {

    val reducer = CounterReducer()
    val state = CounterState(3)

    @Test
    fun increment() {
        assertEquals(state.copy(i = 4), reducer.reduce(state, CounterActions.INCREMENT))
    }

    @Test
    fun decrement() {
        assertEquals(state.copy(i = 2), reducer.reduce(state, CounterActions.DECREMENT))
    }

    @Test
    fun otherwise() {
        assertEquals(state, reducer.reduce(state, 123))
    }

}