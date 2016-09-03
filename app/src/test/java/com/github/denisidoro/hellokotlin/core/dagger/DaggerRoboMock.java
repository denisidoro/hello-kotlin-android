package com.github.denisidoro.hellokotlin.core.dagger;

import com.github.denisidoro.hellokotlin.core.dagger.modules.ApplicationProvider;
import com.github.denisidoro.hellokotlin.core.dagger.providers.RoboApplicationProvider;

public class DaggerRoboMock extends DaggerMock {

    public static ApplicationProvider setup () {
        ApplicationProvider provider = new RoboApplicationProvider();
        setup(provider);
        return provider;
    }

}
