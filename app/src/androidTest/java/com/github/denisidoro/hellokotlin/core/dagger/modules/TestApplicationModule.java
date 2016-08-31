package com.github.denisidoro.hellokotlin.core.dagger.modules;

import android.app.Application;
import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.github.denisidoro.hellokotlin.core.App;
import com.github.denisidoro.hellokotlin.model.Joke;
import com.github.denisidoro.hellokotlin.model.Value;
import com.github.denisidoro.hellokotlin.provider.NorrisProvider;
import com.google.gson.Gson;

import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import rx.Single;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;

@Module
public class TestApplicationModule {

    public TestApplicationModule (Application application) {
        this.application = application;
    }

    public TestApplicationModule () {
        this((App) InstrumentationRegistry.getTargetContext().getApplicationContext());
    }

    public final Application application;

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
    NorrisProvider provideNorrisProvider() {
        NorrisProvider provider = Mockito.mock(NorrisProvider.class);
        Joke joke = new Joke(new Value(13, "mocked joke"));
        doReturn(Single
                .just(joke)
                .delay(3000, TimeUnit.MILLISECONDS)
        ).when(provider).getJoke(anyInt());
        return provider;
    }

}
