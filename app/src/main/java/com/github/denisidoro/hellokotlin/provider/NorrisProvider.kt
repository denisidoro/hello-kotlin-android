package com.github.denisidoro.hellokotlin.provider

import com.github.denisidoro.hellokotlin.model.Joke
import com.github.denisidoro.hellokotlin.utils.parse
import com.github.denisidoro.hellokotlin.utils.toObservable
import com.google.gson.Gson
import okhttp3.OkHttpClient
import rx.Single

class NorrisProvider(val client: OkHttpClient, val gson: Gson) {

    fun getJoke(id: Int): Single<Joke> = client
            .toObservable("http://api.icndb.com/jokes/$id")
            .parse(gson, Joke::class.java)
            .toSingle();

}