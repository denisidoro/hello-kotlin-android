package com.github.denisidoro.hellokotlin.core.pattern.activity

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import com.github.denisidoro.hellokotlin.core.pattern.controller.Controller

abstract class BaseActivity<S> : AppCompatActivity() {

    abstract val controller: Controller<S>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(controller.view)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        controller.unbind()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        controller.save(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        controller.load(savedInstanceState)
    }

}
