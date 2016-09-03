package com.github.denisidoro.hellokotlin.core;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.dagger.DaggerException;
import com.github.denisidoro.hellokotlin.core.dagger.Injector;

public class App extends Application {

    @Override
    public void onCreate () {
        super.onCreate();

        try {
            configureDagger();
            //configureAnalytics();
            //configureTimber();
            //configureCalligraphy();
        } catch (Exception e) {
            // error during startup
        }

    }

    private void configureDagger () throws DaggerException {
        Injector.get().applicationComponent(this);
    }

}
