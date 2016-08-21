package com.github.denisidoro.hellokotlin.core.pattern

import android.content.Context
import com.beyondeye.reduks.Store
import trikita.anvil.Anvil
import trikita.anvil.RenderableView

abstract class View<S>(context: Context, private val store: Store<S>): RenderableView(context) {

    fun dispatch(action: Action) = store.dispatch(action)

    fun getState(): S = store.state

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Anvil.mount(this, this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Anvil.unmount(this)
    }

}