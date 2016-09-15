package com.github.denisidoro.hellokotlin.utils

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import rx.Observable
import rx.functions.Func0
import java.io.IOException

fun OkHttpClient.toObservable(request: Request): Observable<Response> = Observable.defer(Func0 {
    try {
        val response = newCall(request).execute()
        return@Func0 Observable.just(response)
    } catch (e: IOException) {
        return@Func0 Observable.error<Response>(e)
    }
})

fun OkHttpClient.toObservable(url: String): Observable<Response> = Observable.defer(Func0 {
    val request = Request.Builder()
            .url(url)
            .build();
    return@Func0 toObservable(request)
})

fun <T> Observable<Response>.parse(gson: Gson, cls: Class<T>): Observable<T> =
        map { response -> gson.fromJson(response.body().charStream(), cls) }