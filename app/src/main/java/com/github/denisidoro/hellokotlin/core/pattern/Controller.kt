package com.github.denisidoro.hellokotlin.core.pattern

import android.support.annotation.CallSuper
import rx.subscriptions.CompositeSubscription
import trikita.anvil.RenderableView

abstract class Controller(protected val activity: BaseActivity) {

    val subscription = CompositeSubscription()

    abstract fun getView(): RenderableView

    @CallSuper
    fun unbind() {
        subscription.unsubscribe()
    }
}
