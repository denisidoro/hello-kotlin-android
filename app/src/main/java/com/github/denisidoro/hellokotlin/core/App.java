package com.github.denisidoro.hellokotlin.core;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.dagger.Injector;

public class App extends Application {

    @Override
    public void onCreate () {
        super.onCreate();

        try {
            Injector.get().applicationComponent(this);
            //configureAnalytics();
            //configureTimber();
            //configureCalligraphy();
        } catch (Exception e) {
            // error during startup
        }

    }

}
