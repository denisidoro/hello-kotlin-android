package com.github.denisidoro.hellokotlin.core.dagger;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.dagger.components.ActivityTopComponent;
import com.github.denisidoro.hellokotlin.core.dagger.components.TestApplicationComponent;
import com.github.denisidoro.hellokotlin.core.dagger.modules.ActivityModule;
import com.github.denisidoro.hellokotlin.core.dagger.modules.ApplicationProvider;
import com.github.denisidoro.hellokotlin.core.pattern.activity.BaseActivity;

import org.mockito.Mockito;

public class TestInjector extends Injector {

    public TestInjector () {}

    public TestInjector (ApplicationProvider provider) {
        applicationComponent(provider.provideApplication());
        setupComponent(provider);
    }

    public interface OnDaggerModuleAddedCallback {
        void onDaggerModuleAdded (ActivityModule overriddenModule);
    }

    private OnDaggerModuleAddedCallback callback;

    @Override
    public void applicationComponent (Application application) {
        this.application = application;
    }

    public void setupComponent (ApplicationProvider provider) {
        applicationComponent = TestApplicationComponent.Initializer.init(provider);
    }

    @Override
    public ActivityTopComponent activityComponent (BaseActivity activity) {
        this.activityComponent = applicationComponent.plus(getOverriddenActivityModule(activity));
        return activityComponent;
    }

    @Override
    public boolean canOverride () {
        return true;
    }

    /*public void setup (ApplicationProvider applicationProviderInterface, OnDaggerModuleAddedCallback callback) throws DaggerException {
        if (applicationProviderInterface == null) {
            throw new DaggerException("ApplicationProvider can't be null");
        }
        setApplicationProvider(applicationProviderInterface);
        initialize();
        addDaggerModuleCallback(callback);
    }*/

    public void addDaggerModuleCallback (OnDaggerModuleAddedCallback callback) {
        this.callback = callback;
    }

    ActivityModule getOverriddenActivityModule (BaseActivity activity) {
        ActivityModule currentTestedModule = Mockito.spy(new ActivityModule(activity));
        if (callback != null) {
            callback.onDaggerModuleAdded(currentTestedModule);
        }
        return currentTestedModule;
    }

}
