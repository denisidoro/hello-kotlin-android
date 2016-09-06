package com.github.denisidoro.hellokotlin.core.dagger;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.dagger.components.ActivityTopComponent;
import com.github.denisidoro.hellokotlin.core.dagger.components.ApplicationTopComponent;
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity;

public interface InjectorInterface {

    void applicationComponent (Application application) throws DaggerException;

    ApplicationTopComponent applicationComponent ();

    ActivityTopComponent activityComponent ();

    ActivityTopComponent activityComponent (BaseActivity activity);

    void resetActivityComponent (BaseActivity activity);

    boolean canOverride ();

}