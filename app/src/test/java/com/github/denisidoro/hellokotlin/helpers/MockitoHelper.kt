package com.github.denisidoro.hellokotlin.helpers

import org.mockito.InOrder
import org.mockito.MockSettings
import org.mockito.MockingDetails
import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer
import org.mockito.stubbing.DeprecatedOngoingStubbing
import org.mockito.stubbing.OngoingStubbing
import org.mockito.stubbing.Stubber
import org.mockito.verification.VerificationMode
import org.mockito.verification.VerificationWithTimeout
import kotlin.reflect.KClass

fun <T> uninitialized(): T = null as T
inline fun <reified T : Any> any() = Mockito.any(T::class.java) ?: uninitialized()
inline fun <reified T : Any> anyArray(): Array<T> = Mockito.any(Array<T>::class.java) ?: arrayOf()
inline fun <reified T : Any> anyCollection(): Collection<T> = Mockito.anyCollectionOf(T::class.java)
inline fun <reified T : Any> anyList(): List<T> = Mockito.anyListOf(T::class.java)
inline fun <reified T : Any> anySet(): Set<T> = Mockito.anySetOf(T::class.java)
inline fun <reified K : Any, reified V : Any> anyMap(): Map<K, V> = Mockito.anyMapOf(K::class.java, V::class.java)

fun atLeast(numInvocations: Int): VerificationMode = Mockito.atLeast(numInvocations)!!
fun atLeastOnce(): VerificationMode = Mockito.atLeastOnce()!!
fun atMost(maxNumberOfInvocations: Int): VerificationMode = Mockito.atMost(maxNumberOfInvocations)!!
fun calls(wantedNumberOfInvocations: Int): VerificationMode = Mockito.calls(wantedNumberOfInvocations)!!

fun <T> doAnswer(answer: (InvocationOnMock) -> T?): Stubber = Mockito.doAnswer { answer(it) }!!

fun doCallRealMethod(): Stubber = Mockito.doCallRealMethod()!!
fun doNothing(): Stubber = Mockito.doNothing()!!
fun doReturn(value: Any?): Stubber = Mockito.doReturn(value)!!
fun doThrow(toBeThrown: KClass<out Throwable>): Stubber = Mockito.doThrow(toBeThrown.java)!!

fun ignoreStubs(vararg mocks: Any): Array<out Any> = Mockito.ignoreStubs(*mocks)!!
fun inOrder(vararg mocks: Any): InOrder = Mockito.inOrder(*mocks)!!

inline fun <reified T : Any> isA(): T? = Mockito.isA(T::class.java)
inline fun <reified T : Any> isNotNull(): T? = Mockito.isNotNull(T::class.java)
inline fun <reified T : Any> isNull(): T? = Mockito.isNull(T::class.java)

inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)!!
inline fun <reified T : Any> mock(defaultAnswer: Answer<Any>): T = Mockito.mock(T::class.java, defaultAnswer)!!
inline fun <reified T : Any> mock(s: MockSettings): T = Mockito.mock(T::class.java, s)!!
inline fun <reified T : Any> mock(s: String): T = Mockito.mock(T::class.java, s)!!

fun mockingDetails(toInspect: Any): MockingDetails = Mockito.mockingDetails(toInspect)!!
fun never(): VerificationMode = Mockito.never()!!
inline fun <reified T : Any> notNull(): T? = Mockito.notNull(T::class.java)
fun only(): VerificationMode = Mockito.only()!!
fun <T> refEq(value: T, vararg excludeFields: String): T? = Mockito.refEq(value, *excludeFields)

fun <T> reset(vararg mocks: T) = Mockito.reset(*mocks)

fun <T> same(value: T): T? = Mockito.same(value)

inline fun <reified T : Any> spy(): T = Mockito.spy(T::class.java)!!
fun <T> spy(value: T): T = Mockito.spy(value)!!

fun <T> stub(methodCall: T): DeprecatedOngoingStubbing<T> = Mockito.stub(methodCall)!!
fun timeout(millis: Long): VerificationWithTimeout = Mockito.timeout(millis)!!
fun times(numInvocations: Int): VerificationMode = Mockito.times(numInvocations)!!
fun validateMockitoUsage() = Mockito.validateMockitoUsage()

fun <T> verify(mock: T): T = Mockito.verify(mock)!!
fun <T> verify(mock: T, mode: VerificationMode): T = Mockito.verify(mock, mode)!!
fun <T> verifyNoMoreInteractions(vararg mocks: T) = Mockito.verifyNoMoreInteractions(*mocks)
fun verifyZeroInteractions(vararg mocks: Any) = Mockito.verifyZeroInteractions(*mocks)

fun <T> whenever(methodCall: T): OngoingStubbing<T> = Mockito.`when`(methodCall)!!
fun withSettings(): MockSettings = Mockito.withSettings()!!

fun <T> Stubber.whenever(mock: T) : T = `when`(mock)