package com.github.denisidoro.hellokotlin.screens.counter

import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity

class CounterActivity : BaseActivity<CounterState>() {

    override val controller: CounterController by lazy { CounterController(this) }

}





