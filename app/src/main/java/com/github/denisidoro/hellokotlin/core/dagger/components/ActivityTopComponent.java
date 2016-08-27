package com.github.denisidoro.hellokotlin.core.dagger.components;

import com.github.denisidoro.hellokotlin.counter.CounterController;

import org.jetbrains.annotations.NotNull;

public interface ActivityTopComponent {

    void inject (@NotNull CounterController counterController);
}
