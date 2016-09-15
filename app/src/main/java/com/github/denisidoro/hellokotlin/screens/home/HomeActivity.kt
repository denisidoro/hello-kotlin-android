package com.github.denisidoro.hellokotlin.screens.home

import com.beyondeye.reduks.Store
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity
import com.github.denisidoro.hellokotlin.core.pattern.controller.Controller
import com.github.denisidoro.hellokotlin.core.pattern.reducer.DummyReducer
import com.github.denisidoro.hellokotlin.core.pattern.view.View
import trikita.anvil.BaseDSL.text
import trikita.anvil.DSL.*

class HomeActivity : BaseActivity<Unit>() {
    override val controller by lazy { HomeController(this) }
}

class HomeController(activity: HomeActivity) : Controller<Unit>(activity) {
    override fun getReducer() = DummyReducer<Unit>()
    override fun getInitialState() = Unit
    override val view by lazy { HomeView(activity, store, selector) }
}

class HomeView(activity: HomeActivity, store: Store<Unit>, selector: Any) : View<Unit>(activity, store, selector) {
    override fun view() {
        linearLayout() {
            button() {
                text("Counter")
                onClick { dispatch(ACTIVITY("/counter")) }
            }
        }
    }
}


