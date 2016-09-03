package com.github.denisidoro.hellokotlin.manager

import com.github.denisidoro.hellokotlin.helpers.whenever
import com.github.denisidoro.hellokotlin.model.Joke
import com.github.denisidoro.hellokotlin.model.Value
import org.mockito.Mockito
import org.mockito.stubbing.Answer
import rx.Single

class TestNorrisManager {

    companion object {
        fun getInstance(): NorrisManager {
            val provider = Mockito.mock<NorrisManager>(NorrisManager::class.java)
            Mockito.doAnswer(Answer {
                val i = it.arguments[0] as Int
                Single.just(Joke(Value(i, "mocked joke " + i)))
            }).whenever<NorrisManager>(provider).getJoke(Mockito.anyInt())
            return provider
        }
    }

}