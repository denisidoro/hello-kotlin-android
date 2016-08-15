package com.github.denisidoro.hellokotlin.core.dagger.components;

import com.github.denisidoro.hellokotlin.core.dagger.modules.ActivityModule;
import com.github.denisidoro.hellokotlin.core.dagger.scopes.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent extends ActivityTopComponent {
}
