package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.core.pattern.Action

sealed class CounterActions {
    object INIT : Action
    object INCREMENT : Action
    object DECREMENT : Action
}