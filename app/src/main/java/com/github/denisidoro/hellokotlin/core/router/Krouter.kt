package com.github.denisidoro.hellokotlin.core.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.github.denisidoro.hellokotlin.core.router.Schema.Type.*
import java.util.*

class Router(url: String, route: Route, activityCls: Class<out Activity>, val context: Context) {

    val intent = Intent(context, activityCls)

    init {
        url.split('/').toTypedArray()
                .zip(route.url.split('/').toTypedArray())
                .filter { it.second.startsWith(':') }
                .map { Pair(it.first, it.second.substring(1)) }
                .forEach {
                    val regex = route.schemas[it.second]?.regex?.let { Schema.Type.from(it) } ?: inferRegex(it.first)
                    when (regex) {
                        INT -> intent.putExtra(it.second, it.first.toInt())
                        FLOAT -> intent.putExtra(it.second, it.first.toFloat())
                        else -> intent.putExtra(it.second, it.first.toString())
                    }
                }
    }

    fun start() {
        context.startActivity(intent)
    }

    internal fun inferRegex(seg: String): Schema.Type {
        return Schema.Type.values()
                .find { seg.matches(it.regex.toRegex()) } ?: STRING
    }
}

class Schema(val regex: String? = null, val default: String? = null) {

    constructor(type: Schema.Type) : this(type.regex)

    enum class Type(val regex: String) {
        INT("^[-+]?[0-9]+$"),
        FLOAT("^[+-]?([0-9]*[.])?[0-9]+$"),
        STRING("");

        companion object {
            fun from(regex: String): Type = Type.values().associateBy(Type::regex)[regex] ?: STRING
        }
    }
}

class Route(val url: String, val schemas: Map<String, Schema> = HashMap())

class Krouter(val context: Context, val routes: Map<Route, Class<out Activity>> = HashMap()) {

    fun start(url: String) = getRouter(url)!!.let { it.start() }

    fun getRouter(url: String) = find(url)?.let { Router(url, it, routes[it]!!, context) }

    internal fun find(url: String): Route? = routes.keys.find { matchesSchema(url, it) }

    internal fun matchesSchema(url: String, route: Route): Boolean {
        val urlSegs = split(url)
        val routeUrlSegs = split(route.url)

        if (routeUrlSegs.size != urlSegs.size)
            return false

        return urlSegs
                .zip(routeUrlSegs)
                .all {
                    if (it.second.startsWith(':')) {
                        it.second.substring(1).let { seg ->
                            route.schemas[seg]?.regex?.let { regex ->
                                regex.length == 0 || it.first.matches(regex.toRegex())
                            } ?: true
                        }
                    } else it.first.equals(it.second)
                }
    }

    private fun split(s: String): Array<String> = s.split('/').toTypedArray()

}