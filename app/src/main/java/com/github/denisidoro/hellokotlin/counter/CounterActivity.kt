package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.core.pattern.BaseActivity

class CounterActivity : BaseActivity<CounterState>() {

    override val controller by lazy { CounterController(this) }

}





