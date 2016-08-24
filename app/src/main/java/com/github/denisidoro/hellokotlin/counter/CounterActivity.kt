package com.github.denisidoro.hellokotlin.counter

import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity

class CounterActivity : BaseActivity<CounterState>() {

    override val component by lazy { CounterComponent(this) }

}





