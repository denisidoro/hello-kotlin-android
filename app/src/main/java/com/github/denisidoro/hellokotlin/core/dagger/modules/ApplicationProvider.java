package com.github.denisidoro.hellokotlin.core.dagger.modules;

import android.app.Application;
import android.content.Context;

import com.github.denisidoro.hellokotlin.core.rx.RxScheduler;
import com.github.denisidoro.hellokotlin.provider.NorrisProvider;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;

public interface ApplicationProvider {

    Application provideApplication ();

    Context provideContext ();

    OkHttpClient provideOkHttpClient ();

    Gson provideGson ();

    NorrisProvider provideNorrisProvider (OkHttpClient client, Gson gson);

    RxScheduler provideRxScheduler ();
}
