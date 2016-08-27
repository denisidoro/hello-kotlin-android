package com.github.denisidoro.hellokotlin.core.dagger.modules;

import android.app.Application;
import android.content.Context;

import com.github.denisidoro.hellokotlin.provider.NorrisProvider;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApplicationModule {

    final Application application;

    public ApplicationModule (Application application) {
        this.application = application;
    }

    /**
     * Expose the application to the graph.
     */
    @Provides
    @Singleton
    Application application () {
        return application;
    }

    @Provides
    @Singleton
    @Named("applicationContext")
    Context provideContext () {
        return application;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient () {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    NorrisProvider provideNorrisProvider(OkHttpClient client, Gson gson) {
        return new NorrisProvider(client, gson);
    }

}
