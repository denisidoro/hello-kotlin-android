package com.github.denisidoro.hellokotlin.screens.counter

import com.beyondeye.reduks.NextDispatcher
import com.beyondeye.reduks.Store
import com.github.denisidoro.hellokotlin.core.dagger.DaggerUnitMock
import com.github.denisidoro.hellokotlin.core.rx.TestRxScheduler
import com.github.denisidoro.hellokotlin.helpers.any
import com.github.denisidoro.hellokotlin.helpers.never
import com.github.denisidoro.hellokotlin.helpers.verify
import com.github.denisidoro.hellokotlin.manager.TestNorrisManager
import com.github.denisidoro.hellokotlin.screens.counter.CounterActions.JOKE_REQUEST
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class CounterMiddlewareTest {

    @Mock
    lateinit var store: Store<CounterState>
    @Mock
    lateinit var next: NextDispatcher

    val scheduler = TestRxScheduler()
    val norrisManager = TestNorrisManager.getInstance()

    lateinit var middleware: CounterMiddleware

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)

        DaggerUnitMock.setup(middleware) {
            it.norrisManager = norrisManager
            it.scheduler = scheduler
        }

        //doReturn(CounterState.default()).whenever(store).state

        middleware = CounterMiddleware()
    }

    @Test
    fun dispatch() {
        verify(next, never()).dispatch(any())

        middleware.dispatch(store, next, JOKE_REQUEST)
        scheduler.advanceTime()

        verify(next).dispatch(any())
    }

}