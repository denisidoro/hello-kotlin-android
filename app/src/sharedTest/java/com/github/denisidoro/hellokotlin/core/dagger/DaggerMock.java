package com.github.denisidoro.hellokotlin.core.dagger;

import com.github.denisidoro.hellokotlin.core.dagger.modules.ApplicationProvider;

import static junit.framework.Assert.fail;

public class DaggerMock {

    public static void setup (ApplicationProvider provider) {
        try {
            TestInjector injector = new TestInjector(provider);
            Injector.setInstance(injector);
        } catch (DaggerException e) {
            fail(e.getMessage());
        }
    }

}
