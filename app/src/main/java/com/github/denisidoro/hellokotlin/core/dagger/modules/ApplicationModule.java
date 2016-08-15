package com.github.denisidoro.hellokotlin.core.dagger.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

}
