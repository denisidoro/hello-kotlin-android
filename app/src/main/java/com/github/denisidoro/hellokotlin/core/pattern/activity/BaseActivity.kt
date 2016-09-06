package com.github.denisidoro.hellokotlin.core.pattern.activity

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import com.github.denisidoro.hellokotlin.core.dagger.Injector
import com.github.denisidoro.hellokotlin.core.pattern.controller.Controller

abstract class BaseActivity<S> : AppCompatActivity() {

    abstract val controller: Controller<S>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(controller.view)
        Injector.get().activityComponent(this)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        controller.unbind()
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        Injector.get().activityComponent(this)
    }

    @CallSuper
    override fun onPause() {
        super.onPause()
        Injector.get().resetActivityComponent(this)
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
