package com.github.denisidoro.hellokotlin.core.dagger.modules;

import android.content.Context;

import com.github.denisidoro.hellokotlin.core.dagger.scopes.PerActivity;
import com.github.denisidoro.hellokotlin.core.pattern.BaseActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    public BaseActivity activity;

    public ActivityModule (BaseActivity activity) {
        this.activity = activity;
    }

    public ActivityModule () {
    }

    /**
     * Expose the context to the graph.
     */
    @Provides
    @PerActivity
    @Named("activityContext")
    public Context provideContext () {
        return activity;
    }

    @Provides
    @PerActivity
    public BaseActivity provideBaseActivity () {
        return activity;
    }

}

