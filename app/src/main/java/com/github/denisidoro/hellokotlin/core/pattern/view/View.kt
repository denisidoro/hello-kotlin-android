package com.github.denisidoro.hellokotlin.core.pattern.view

import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity
import com.github.denisidoro.hellokotlin.core.pattern.proxy.Proxy
import trikita.anvil.Anvil
import trikita.anvil.RenderableView

abstract class View(val activity: BaseActivity<*>, private val proxy: Proxy): RenderableView(activity) {

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