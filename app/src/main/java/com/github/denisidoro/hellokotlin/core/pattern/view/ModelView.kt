package com.github.denisidoro.hellokotlin.core.pattern.view

import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity
import com.github.denisidoro.hellokotlin.core.pattern.proxy.ModelProxy

abstract class ModelView<M>(activity: BaseActivity<*>, private val proxy: ModelProxy<M>) : View(activity, proxy) {

    override fun view() {
        view(proxy.getModel())
    }

    abstract fun view(model: M)

}