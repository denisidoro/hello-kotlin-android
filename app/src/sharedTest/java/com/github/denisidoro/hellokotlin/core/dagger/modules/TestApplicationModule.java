package com.github.denisidoro.hellokotlin.core.dagger.modules;

import android.app.Application;
import android.content.Context;

import com.github.denisidoro.hellokotlin.core.rx.RxScheduler;
import com.github.denisidoro.hellokotlin.manager.NorrisManager;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class TestApplicationModule implements ApplicationProvider {

    public final ApplicationProvider provider;

    public TestApplicationModule (ApplicationProvider provider) {
        this.provider = provider;
    }

    @Provides
    @Singleton
    @Override
    public Application provideApplication () {
        return provider.provideApplication();
    }

    @Provides
    @Singleton
    @Override
    @Named("applicationContext")
    public Context provideContext () {
        return provider.provideContext();
    }

    @Provides
    @Singleton
    @Override
    public OkHttpClient provideOkHttpClient () {
        return provider.provideOkHttpClient();
    }

    @Provides
    @Singleton
    @Override
    public Gson provideGson() {
        return provider.provideGson();
    }

    @Provides
    @Singleton
    @Override
    public NorrisManager provideNorrisManager (OkHttpClient client, Gson gson) {
        return provider.provideNorrisManager(client, gson);
    }

    @Provides
    @Singleton
    @Override
    public RxScheduler provideRxScheduler() {
        return provider.provideRxScheduler();
    }

}
