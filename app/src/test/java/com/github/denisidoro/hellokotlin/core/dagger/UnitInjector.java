package com.github.denisidoro.hellokotlin.core.dagger;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.dagger.components.ActivityTopComponent;
import com.github.denisidoro.hellokotlin.core.dagger.components.ApplicationTopComponent;
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity;

public class UnitInjector implements InjectorInterface {

    ApplicationTopComponent applicationComponent;
    ActivityTopComponent activityComponent;

    @Override
    public ApplicationTopComponent applicationComponent () {
        return applicationComponent;
    }

    @Override
    public void applicationComponent (Application application) throws DaggerException {

    }

    @Override
    public ActivityTopComponent activityComponent (BaseActivity activity) {
        return activityComponent();
    }

    public ActivityTopComponent activityComponent () {
        return activityComponent;
    }

    public void resetActivityComponent (BaseActivity activity) {
    }

    @Override
    public boolean canOverride () {
        return true;
    }

    public void setApplicationComponent (ApplicationTopComponent topComponent) throws DaggerException {
        applicationComponent = topComponent;
    }

    public void setActivityComponent (ActivityTopComponent topComponent) throws DaggerException {
        activityComponent = topComponent;
    }

    public interface DaggerCallback<T> {
        void call (T object);
    }

}
