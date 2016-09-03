package com.github.denisidoro.hellokotlin.core.dagger;

import com.github.denisidoro.hellokotlin.core.dagger.modules.ApplicationProvider;
import com.github.denisidoro.hellokotlin.core.dagger.providers.EspressoApplicationProvider;

public class DaggerEspressoMock extends DaggerMock {

    public static ApplicationProvider setup () {
        ApplicationProvider provider = new EspressoApplicationProvider();
        setup(provider);
        return provider;
    }

}
