package com.github.denisidoro.hellokotlin.core.dagger.providers;

import android.app.Application;
import android.content.Context;

import com.github.denisidoro.hellokotlin.core.dagger.modules.ApplicationProvider;
import com.github.denisidoro.hellokotlin.core.rx.MultiThreadRxScheduler;
import com.github.denisidoro.hellokotlin.core.rx.RxScheduler;
import com.github.denisidoro.hellokotlin.manager.NorrisManager;
import com.github.denisidoro.hellokotlin.manager.TestNorrisManager;
import com.google.gson.Gson;

import javax.inject.Named;

import okhttp3.OkHttpClient;

public class TestApplicationProvider implements ApplicationProvider {

    public TestApplicationProvider (Application application) {
        this.application = application;
    }

    public final Application application;

    @Override
    public Application provideApplication () {
        return application;
    }

    @Override
    @Named("applicationContext")
    public Context provideContext () {
        return application;
    }

    @Override
    public OkHttpClient provideOkHttpClient () {
        return new OkHttpClient();
    }

    @Override
    public Gson provideGson () {
        return new Gson();
    }

    @Override
    public NorrisManager provideNorrisManager (OkHttpClient client, Gson gson) {
        return TestNorrisManager.Companion.getInstance();
    }

    @Override
    public RxScheduler provideRxScheduler () {
        return new MultiThreadRxScheduler();
    }

}
