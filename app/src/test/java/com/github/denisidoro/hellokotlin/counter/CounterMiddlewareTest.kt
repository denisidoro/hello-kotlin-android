package com.github.denisidoro.hellokotlin.counter

import com.beyondeye.reduks.NextDispatcher
import com.beyondeye.reduks.Store
import com.github.denisidoro.hellokotlin.core.dagger.DaggerUnitMock
import com.github.denisidoro.hellokotlin.core.rx.TestRxScheduler
import com.github.denisidoro.hellokotlin.counter.CounterActions.JOKE_REQUEST
import com.github.denisidoro.hellokotlin.helpers.*
import com.github.denisidoro.hellokotlin.manager.TestNorrisManager
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

        DaggerUnitMock.setup(CounterMiddleware::class.java, {
            it.norrisManager = norrisManager
            it.scheduler = scheduler
        })

        doReturn(CounterState(43, null)).whenever(store).state

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