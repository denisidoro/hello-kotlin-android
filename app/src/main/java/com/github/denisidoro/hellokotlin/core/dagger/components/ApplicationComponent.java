/*
 * Copyright (C) 2013 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.denisidoro.hellokotlin.core.dagger.components;

import android.app.Application;

import com.github.denisidoro.hellokotlin.core.dagger.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent extends ApplicationTopComponent {

    final class Initializer {
        public static ApplicationComponent init (Application app) {

            return DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(app)).build();
        }

        private Initializer () {
        } // No instances.
    }

}
