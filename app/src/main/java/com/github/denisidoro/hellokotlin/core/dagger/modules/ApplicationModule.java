package com.github.denisidoro.hellokotlin.core.dagger.modules;

import android.app.Application;
import android.content.Context;

import com.github.denisidoro.hellokotlin.core.rx.MultiThreadRxScheduler;
import com.github.denisidoro.hellokotlin.core.rx.RxScheduler;
import com.github.denisidoro.hellokotlin.manager.NorrisManager;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApplicationModule implements ApplicationProvider {

    public final Application application;

    public ApplicationModule (Application application) {
        this.application = application;
    }

    /**
     * Expose the application to the graph.
     */
    @Override
    @Provides
    @Singleton
    public Application provideApplication () {
        return application;
    }

    @Override
    @Provides
    @Singleton
    @Named("applicationContext")
    public Context provideContext () {
        return application;
    }

    @Override
    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient () {
        return new OkHttpClient();
    }

    @Override
    @Provides
    @Singleton
    public Gson provideGson () {
        return new Gson();
    }

    @Override
    @Provides
    @Singleton
    public NorrisManager provideNorrisManager (OkHttpClient client, Gson gson) {
        return new NorrisManager(client, gson);
    }

    @Override
    @Provides
    @Singleton
    public RxScheduler provideRxScheduler () {
        return new MultiThreadRxScheduler();
    }

}
