package com.github.denisidoro.hellokotlin.core.router

import android.app.Activity
import android.content.Context
import android.content.Intent
import java.util.*

class Router(url: String, route: Route, cls: Class<*>, val context: Context) {

    val intent = Intent(context, cls)

    init {
        url.split('/').toTypedArray()
                .filter { it.startsWith(':') }
                .map { it.substring(1) }
                .forEach {
                    val type = route.schemaTable[it]!!.type ?: inferType(it)
                    when (type) {
                        Int -> intent.putExtra(it, it.toInt())
                        Float -> intent.putExtra(it, it.toFloat())
                        Double -> intent.putExtra(it, it.toDouble())
                        else -> intent.putExtra(it, it.toString())
                    }
                }
    }

    fun start() {
        context.startActivity(intent)
    }

    private fun inferType(segment: String) = Int

}

class Schema(val type: Class<*>?, val regex: String?)

class Route(val uri: String, val schemaTable: Map<String, Schema> = HashMap())

class Kouter(val context: Context, val routeTable: Map<Route, Class<out Activity>> = HashMap()) {

    fun find(url: String): Route? = routeTable.keys.find { matchesSchema(url, it) }

    fun getRouter(url: String) = find(url)?.let { Router(url, it, routeTable[it]!!, context) }

    fun start(url: String) = getRouter(url)!!.let { it.start() }

    fun matchesSchema(url: String, route: Route): Boolean {
        val segs: Array<String> = url.split('/').toTypedArray()
        return matchesRoute(segs, route.uri) && matchesProps(segs, route.schemaTable)
    }

    fun matchesRoute(urlSegs: Array<String>, uri: String): Boolean {
        val routeSegs: Array<String> = uri.split('/').toTypedArray()

        if (routeSegs.size != urlSegs.size)
            return false

        return urlSegs
                .zip(routeSegs)
                .all { it.first.startsWith(':') || it.first.equals(it.second) }
    }

    fun matchesProps(urlSegs: Array<String>, schemaTable: Map<String, Schema>): Boolean {
        return urlSegs
                .filter { it.startsWith(':') }
                .map { it.substring(1) }
                .map { Pair(it, schemaTable[it]) }
                .all { pair ->
                    pair.second!!.regex?.let {
                        pair.first.matches(it.toRegex())
                    } ?: true
                }
    }

}