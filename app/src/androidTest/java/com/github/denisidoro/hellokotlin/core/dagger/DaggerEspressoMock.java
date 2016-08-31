package com.github.denisidoro.hellokotlin.core.dagger;

import com.github.denisidoro.hellokotlin.core.dagger.modules.TestApplicationModule;

import static junit.framework.Assert.fail;

public class DaggerEspressoMock {

    public static void setup (TestApplicationModule module) {
        try {
            EspressoInjector injector = new EspressoInjector(module);
            Injector.setInstance(injector);
        } catch (DaggerException e) {
            fail(e.getMessage());
        }
    }

    public static void setup () {
        setup(new TestApplicationModule());
    }

}
