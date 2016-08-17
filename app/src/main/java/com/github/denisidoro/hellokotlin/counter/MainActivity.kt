package com.github.denisidoro.hellokotlin.counter

import android.os.Bundle
import com.github.denisidoro.hellokotlin.core.pattern.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val controller = CounterController(this)
        setContentView(controller.getView())
    }

}





