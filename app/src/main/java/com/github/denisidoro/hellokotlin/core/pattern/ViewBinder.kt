package com.github.denisidoro.hellokotlin.core.pattern

import rx.Observable
import rx.subjects.PublishSubject
import trikita.anvil.RenderableView

abstract class ViewBinder<S>(val activity: BaseActivity<S>) : RenderableView(activity) {

    private val dispatchRequestSubject: PublishSubject<Action> = PublishSubject.create()
    val dispatchRequests: Observable<Action> = dispatchRequestSubject.asObservable()

    protected fun requestAction(action: Action) {
        dispatchRequestSubject.onNext(action)
    }

}
