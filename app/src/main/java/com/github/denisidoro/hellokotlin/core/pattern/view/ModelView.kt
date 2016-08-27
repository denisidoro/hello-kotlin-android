package com.github.denisidoro.hellokotlin.core.pattern.view

import android.support.v7.app.AppCompatActivity
import com.github.denisidoro.hellokotlin.core.pattern.proxy.ModelProxy

abstract class ModelView<M>(activity: AppCompatActivity, private val proxy: ModelProxy<M>) : View(activity, proxy) {

    override fun view() {
        view(proxy.getModel())
    }

    abstract fun view(model: M)

}