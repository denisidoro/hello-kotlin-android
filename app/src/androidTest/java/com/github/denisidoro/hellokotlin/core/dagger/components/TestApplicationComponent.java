package com.github.denisidoro.hellokotlin.core.dagger.components;

import com.github.denisidoro.hellokotlin.core.dagger.modules.TestApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {TestApplicationModule.class})
public interface TestApplicationComponent extends ApplicationTopComponent {

    final class Initializer {
        private Initializer () {
        } // No instances.

        public static TestApplicationComponent init (TestApplicationModule applicationModule) {

            return DaggerTestApplicationComponent.builder()
                    .testApplicationModule(applicationModule).build();
        }
    }

}
