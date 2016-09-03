package com.github.denisidoro.hellokotlin.core.dagger.providers;

import com.github.denisidoro.hellokotlin.core.rx.RxScheduler;
import com.github.denisidoro.hellokotlin.core.rx.TestRxScheduler;

import org.robolectric.RuntimeEnvironment;

public class RoboApplicationProvider extends TestApplicationProvider {

    public RoboApplicationProvider () {
        super(RuntimeEnvironment.application);
    }

    @Override
    public RxScheduler provideRxScheduler () {
        return new TestRxScheduler();
    }
}
