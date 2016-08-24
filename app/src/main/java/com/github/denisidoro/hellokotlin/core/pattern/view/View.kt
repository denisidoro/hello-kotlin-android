package com.github.denisidoro.hellokotlin.core.pattern.view

import com.github.denisidoro.hellokotlin.core.pattern.action.Action
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity
import trikita.anvil.Anvil
import trikita.anvil.RenderableView

abstract class View(val activity: BaseActivity<*>, val dispatch: (action: Action) -> Unit): RenderableView(activity) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Anvil.mount(this, this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Anvil.unmount(this)
    }

}