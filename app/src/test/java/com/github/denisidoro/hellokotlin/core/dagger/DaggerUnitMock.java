package com.github.denisidoro.hellokotlin.core.dagger;
import com.github.denisidoro.hellokotlin.core.dagger.components.ActivityComponent;
import com.github.denisidoro.hellokotlin.core.dagger.components.ApplicationComponent;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

public class DaggerUnitMock {

    public static <T> void setup (final Class<T> cls, final UnitInjector.DaggerCallback<T> callback) {

        try {
            Answer answer = new Answer() {
                @Override
                public Object answer (InvocationOnMock invocation) throws Throwable {
                    for (Object ob : invocation.getArguments()) {
                        if (callback != null && cls != null && cls.isInstance(ob)) {
                            callback.call((T) ob);
                        }
                    }
                    return null;
                }
            };

            UnitInjector injector = new UnitInjector();
            injector.setApplicationComponent(mock(ApplicationComponent.class, answer));
            injector.setActivityComponent(mock(ActivityComponent.class, answer));
            Injector.setInstance(injector);

        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
