package com.github.denisidoro.hellokotlin.core.dagger;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.dagger.components.ActivityTopComponent;
import com.github.denisidoro.hellokotlin.core.dagger.components.ApplicationComponent;
import com.github.denisidoro.hellokotlin.core.dagger.components.ApplicationTopComponent;
import com.github.denisidoro.hellokotlin.core.dagger.modules.ActivityModule;
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity;

public class Injector implements InjectorInterface {

    //region Static instance and method

    protected static InjectorInterface instance;

    public static InjectorInterface get () {
        if (instance == null) {
            instance = new Injector();
        }
        return instance;
    }

    public static void setInstance (InjectorInterface injector) throws DaggerException {
        if (!injector.canOverride()) {
            throw new DaggerException("Force setting Injector instance is not allowed with the current Injector");
        }
        instance = injector;
    }

    //endregion

    //region Member variables

    protected Application application;
    protected ApplicationTopComponent applicationComponent;
    protected ActivityTopComponent activityComponent;

    protected String activityClassName;

    //endregion

    //region Application component

    @Override
    public void applicationComponent (Application application) throws DaggerException {
        if (applicationComponent != null) {
            throw new DaggerException("Force setting application component when it's not null is not allowed with the current Injector");
        }
        this.application = application;
        initialize();
    }

    @Override
    public ApplicationTopComponent applicationComponent () {
        return applicationComponent;
    }

    //endregion

    //region Activity component

    @Override
    public ActivityTopComponent activityComponent () {
        return activityComponent;
    }

    @Override
    public ActivityTopComponent activityComponent (BaseActivity activity) {
        if (activityComponent != null && activity.getClass().getName().equals(activityClassName)) {
            return activityComponent;
        }
        reset();
        initialize();
        activityComponent = applicationComponent.plus(new ActivityModule(activity));
        activityClassName = activity.getClass().getName();
        return activityComponent;
    }

    //endregion

    //region Helpers

    private void reset () {
        this.activityComponent = null;
        this.activityClassName = "";
    }

    @Override
    public void resetActivityComponent (BaseActivity activity) {
        if (activity.getClass().getName().equals(this.activityClassName)) {
            reset();
        }
    }

    @Override
    public boolean canOverride () {
        return false;
    }

    protected void initialize () {
        if (applicationComponent == null) {
            applicationComponent = ApplicationComponent.Initializer.init(application);
        }
    }

    //endregion

}