package com.github.denisidoro.hellokotlin.provider

import com.github.denisidoro.hellokotlin.model.Joke
import com.github.denisidoro.hellokotlin.utils.NetworkUtils.okHttpObservable
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import rx.Single

class NorrisProvider(val client: OkHttpClient, val gson: Gson) {

    fun getJoke(id: Int): Single<Joke> {
        val request = Request.Builder()
                .url("http://api.icndb.com/jokes/$id")
                .build();
        return okHttpObservable(client, request, gson, Joke::class.java)
                .toSingle();
    }

}