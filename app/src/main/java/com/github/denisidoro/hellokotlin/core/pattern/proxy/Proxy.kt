package com.github.denisidoro.hellokotlin.core.pattern.proxy

import com.github.denisidoro.hellokotlin.core.pattern.action.Action

open class Proxy (val dispatch: (Action) -> Unit)
