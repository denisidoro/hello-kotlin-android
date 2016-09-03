package com.github.denisidoro.hellokotlin.core.pattern.proxy

open class ModelProxy<M> (dispatch: (Any) -> Any, open val getModel: () -> M) : Proxy(dispatch)

