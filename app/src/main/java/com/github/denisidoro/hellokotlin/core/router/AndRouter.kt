package com.github.denisidoro.hellokotlin.core.router

import cn.campusapp.router.route.IRoute

interface AndRouter {

    fun open(url: String): Boolean

    fun getRoute(url: String): IRoute

}
