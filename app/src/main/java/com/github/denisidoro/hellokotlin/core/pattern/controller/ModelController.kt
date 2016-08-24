package com.github.denisidoro.hellokotlin.core.pattern.controller

import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity
import com.github.denisidoro.hellokotlin.core.pattern.proxy.ModelProxy

abstract class ModelController<S, M>(activity: BaseActivity<S>) : Controller<S>(activity) {

    abstract fun getModel(): M

    override val proxy = ModelProxy<M>(dispatch, { getModel() })

}
