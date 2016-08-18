package com.github.denisidoro.hellokotlin.core.pattern

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import java.util.*

abstract class BaseActivity<S> : AppCompatActivity() {

    val controllers = ArrayList<Controller<S>>()

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        controllers.forEach { it.unbind() }
    }

    fun addController(controller: Controller<S>) {
        controllers.add(controller)
    }

    abstract fun mainController(): Controller<S>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainController = mainController()
        setContentView(mainController.view)
        addController(mainController)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        mainController().save(outState)
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        mainController().load(savedInstanceState)
    }

}
