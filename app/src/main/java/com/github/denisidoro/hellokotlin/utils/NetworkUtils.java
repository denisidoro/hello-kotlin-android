package com.github.denisidoro.hellokotlin.utils;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

public class NetworkUtils {

    public static Observable<Response> okHttpObservable(final OkHttpClient client, final Request request) {
        return Observable.defer(new Func0<Observable<Response>>() {
            @Override public Observable<Response> call() {
                try {
                    Response response = client.newCall(request).execute();
                    return Observable.just(response);
                } catch (IOException e) {
                    return Observable.error(e);
                }
            }
        });
    }

    public static <T> Observable<T> okHttpObservable(final OkHttpClient client, final Request request, final Gson gson, final Class<T> cls) {
        return okHttpObservable(client, request)
                .map(new Func1<Response, T>() {
                    @Override
                    public T call (Response response) {
                        return gson.fromJson(response.body().charStream(), cls);
                    }
                });
    }

}
