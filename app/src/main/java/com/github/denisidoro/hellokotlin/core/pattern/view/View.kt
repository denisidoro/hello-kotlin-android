package com.github.denisidoro.hellokotlin.core.pattern.view

import android.support.v7.app.AppCompatActivity
import com.github.denisidoro.hellokotlin.core.pattern.proxy.Proxy
import trikita.anvil.Anvil
import trikita.anvil.RenderableView

abstract class View(val activity: AppCompatActivity, private val proxy: Proxy): RenderableView(activity) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Anvil.mount(this, this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Anvil.unmount(this)
    }

    val dispatch = proxy.dispatch

}