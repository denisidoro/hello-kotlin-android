package com.github.denisidoro.hellokotlin.core.pattern

import rx.Observable
import rx.subjects.PublishSubject
import trikita.anvil.Anvil
import trikita.anvil.RenderableView

abstract class ViewBinder<S>(activity: BaseActivity<S>) : RenderableView(activity) {

    val dispatchSubject: PublishSubject<Action> = PublishSubject.create()
    val dispatchObservable: Observable<Action> = dispatchSubject.asObservable()
    var state: S? = null

    abstract fun viewFromState(state: S)

    override fun view() {
        if (state != null)
            viewFromState(state!!)
    }

    protected fun dispatch(action: Action) {
        dispatchSubject.onNext(action)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Anvil.mount(this, this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Anvil.unmount(this)
    }

}
