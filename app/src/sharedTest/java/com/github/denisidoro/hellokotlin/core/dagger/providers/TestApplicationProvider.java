package com.github.denisidoro.hellokotlin.core.dagger.providers;

import android.app.Application;
import android.content.Context;

import com.github.denisidoro.hellokotlin.core.dagger.modules.ApplicationProvider;
import com.github.denisidoro.hellokotlin.core.rx.MultiThreadRxScheduler;
import com.github.denisidoro.hellokotlin.core.rx.RxScheduler;
import com.github.denisidoro.hellokotlin.model.Joke;
import com.github.denisidoro.hellokotlin.model.Value;
import com.github.denisidoro.hellokotlin.provider.NorrisProvider;
import com.google.gson.Gson;

import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import okhttp3.OkHttpClient;
import rx.Single;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;

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
    public Gson provideGson() {
        return new Gson();
    }

    @Override
    public NorrisProvider provideNorrisProvider(OkHttpClient client, Gson gson) {
        NorrisProvider provider = Mockito.mock(NorrisProvider.class);
        Joke joke = new Joke(new Value(13, "mocked joke"));
        doReturn(Single
                .just(joke)
                .delay(3000, TimeUnit.MILLISECONDS)
        ).when(provider).getJoke(anyInt());
        return provider;
    }

    @Override
    public RxScheduler provideRxScheduler() {
        return new MultiThreadRxScheduler();
    }

}
