package com.github.denisidoro.hellokotlin.core.dagger.components;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.dagger.modules.ActivityModule;
import com.github.denisidoro.hellokotlin.counter.CounterMiddleware;

import org.jetbrains.annotations.NotNull;

public interface ApplicationTopComponent {

    Application application ();

    ActivityComponent plus (ActivityModule module);

    void inject (@NotNull CounterMiddleware counterMiddleware);
}
