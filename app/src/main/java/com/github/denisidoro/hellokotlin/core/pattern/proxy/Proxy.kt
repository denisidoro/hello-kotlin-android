package com.github.denisidoro.hellokotlin.core.pattern.proxy

class Proxy<S>(val getState: () -> S, val dispatch: (Any) -> Any)