package com.github.denisidoro.hellokotlin.core.pattern

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    val controllers = ArrayList<Controller>()

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        controllers.forEach { it.unbind() }
    }

    fun addController(controller: Controller) {
        controllers.add(controller)
    }

    abstract fun mainController(): Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainController = mainController()
        setContentView(mainController.view)
        addController(mainController)
    }

}
