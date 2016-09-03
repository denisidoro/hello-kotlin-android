package com.github.denisidoro.hellokotlin.core.dagger.providers;

import android.app.Application;
import android.support.test.InstrumentationRegistry;

public class EspressoApplicationProvider extends TestApplicationProvider {

    public EspressoApplicationProvider () {
        super((Application) InstrumentationRegistry.getTargetContext().getApplicationContext());
    }

}
