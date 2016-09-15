package com.github.denisidoro.hellokotlin.core.router

import cn.campusapp.router.route.IRoute

class TestAndRouter: AndRouter {
    override fun open(url: String): Boolean {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRoute(url: String): IRoute {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}