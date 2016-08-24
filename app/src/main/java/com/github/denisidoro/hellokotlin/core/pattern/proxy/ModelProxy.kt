package com.github.denisidoro.hellokotlin.core.pattern.proxy

import com.github.denisidoro.hellokotlin.core.pattern.action.Action

class ModelProxy<M> (dispatch: (Action) -> Unit, val getModel: () -> M) : Proxy(dispatch)

