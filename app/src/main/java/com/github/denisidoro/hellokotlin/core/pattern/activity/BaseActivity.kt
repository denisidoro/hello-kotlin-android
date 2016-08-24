package com.github.denisidoro.hellokotlin.core.pattern.activity

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import com.github.denisidoro.hellokotlin.core.pattern.controller.Component

abstract class BaseActivity<S> : AppCompatActivity() {

    abstract val component: Component<S>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(component.view)
    }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        component.unbind()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        component.save(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        component.load(savedInstanceState)
    }

}
