package com.github.denisidoro.hellokotlin.core.pattern

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<S> : AppCompatActivity() {

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        controller.unbind()
    }

    val controller: Controller<S> by lazy { getMainController() }

    abstract fun getMainController(): Controller<S>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(controller.view)
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
