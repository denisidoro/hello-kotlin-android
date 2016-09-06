package com.github.denisidoro.hellokotlin.core.pattern.view

import com.beyondeye.reduks.AbstractSelector
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity
import com.github.denisidoro.hellokotlin.core.pattern.proxy.Proxy
import trikita.anvil.Anvil
import trikita.anvil.RenderableView

abstract class View<S> (open val activity: BaseActivity<S>, val proxy: Proxy<S>, open val selector: Any?)
: RenderableView(activity) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Anvil.mount(this, this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Anvil.unmount(this)
    }

    fun dispatch (vararg actions: Any) {
        actions.forEach { proxy.dispatch(it) }
    }

    inline fun <reified T> defer(selector: AbstractSelector<S, T>): T
            = selector(proxy.getState())

}