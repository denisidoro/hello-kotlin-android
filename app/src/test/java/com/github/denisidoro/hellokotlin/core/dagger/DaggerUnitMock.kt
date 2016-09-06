package com.github.denisidoro.hellokotlin.core.dagger

import com.github.denisidoro.hellokotlin.core.dagger.components.ActivityComponent
import com.github.denisidoro.hellokotlin.core.dagger.components.ApplicationComponent
import org.junit.Assert.fail
import org.mockito.Mockito.mock
import org.mockito.stubbing.Answer

object DaggerUnitMock {

    fun setup(answer: Answer<*>) {
        try {
            val injector = UnitInjector()
            injector.setApplicationComponent(mock<ApplicationComponent>(ApplicationComponent::class.java, answer))
            injector.setActivityComponent(mock<ActivityComponent>(ActivityComponent::class.java, answer))
            Injector.setInstance(injector)
        } catch (e: Exception) {
            fail(e.message)
        }
    }

    fun setup(f: () -> Unit) {
        setup(Answer { f() })
    }

    inline fun <reified T> setup(obj: T, crossinline block: (T) -> Unit) {
        setup(Answer { obj.let(block) })
    }

}