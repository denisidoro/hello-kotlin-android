package com.github.denisidoro.hellokotlin.core.dagger.providers;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.rx.RxScheduler;
import com.github.denisidoro.hellokotlin.core.rx.TestRxScheduler;

import static org.mockito.Mockito.mock;

public class UnitApplicationProvider extends TestApplicationProvider {

    public UnitApplicationProvider () {
        super(mock(Application.class));
    }

    @Override
    public RxScheduler provideRxScheduler () {
        return new TestRxScheduler();
    }
}
