package com.github.denisidoro.hellokotlin.core.pattern.proxy

class ModelProxy<M> (dispatch: (Any) -> Any, val getModel: () -> M) : Proxy(dispatch)

