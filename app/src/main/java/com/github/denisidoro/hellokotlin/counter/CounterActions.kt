package com.github.denisidoro.hellokotlin.counter

sealed class CounterActions {
    object INCREMENT
    object DECREMENT
}