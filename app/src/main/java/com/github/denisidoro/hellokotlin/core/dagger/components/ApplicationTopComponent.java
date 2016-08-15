package com.github.denisidoro.hellokotlin.core.dagger.components;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.dagger.modules.ActivityModule;

public interface ApplicationTopComponent {

    Application application ();

    ActivityComponent plus (ActivityModule module);

}
