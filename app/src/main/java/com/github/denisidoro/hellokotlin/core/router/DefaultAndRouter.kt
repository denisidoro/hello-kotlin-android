package com.github.denisidoro.hellokotlin.core.router

import android.content.Context
import cn.campusapp.router.Router
import cn.campusapp.router.route.ActivityRoute
import cn.campusapp.router.router.IActivityRouteTableInitializer

class DefaultAndRouter(context: Context, initializer: IActivityRouteTableInitializer): AndRouter {

    init {
        Router.initActivityRouter(context, initializer)
    }

    override fun open(url: String) = Router.open(url)

    override fun getRoute(url: String): ActivityRoute = Router.getRoute(url) as ActivityRoute

}