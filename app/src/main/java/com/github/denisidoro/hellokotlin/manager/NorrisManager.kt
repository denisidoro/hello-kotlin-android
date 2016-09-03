package com.github.denisidoro.hellokotlin.manager

import com.github.denisidoro.hellokotlin.model.Joke
import com.github.denisidoro.hellokotlin.utils.parse
import com.github.denisidoro.hellokotlin.utils.toObservable
import com.google.gson.Gson
import okhttp3.OkHttpClient
import rx.Single
import java.util.concurrent.TimeUnit

open class NorrisManager(val client: OkHttpClient, val gson: Gson) {

    open fun getJoke(id: Int): Single<Joke> = client
            .toObservable("http://api.icndb.com/jokes/$id")
            .parse(gson, Joke::class.java)
            .toSingle()
            .delay(2500, TimeUnit.MILLISECONDS); // for demo purposes

}