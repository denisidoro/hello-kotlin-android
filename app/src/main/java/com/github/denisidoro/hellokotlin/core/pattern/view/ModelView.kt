package com.github.denisidoro.hellokotlin.core.pattern.view

import com.github.denisidoro.hellokotlin.core.pattern.action.Action
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity

abstract class ModelView<M>(activity: BaseActivity<*>, dispatch: (action: Action) -> Unit, val getModel: () -> M)
: View(activity, dispatch) {

    override fun view() {
        view(getModel())
    }

    abstract fun view(model: M)

}