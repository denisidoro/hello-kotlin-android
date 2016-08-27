package com.github.denisidoro.hellokotlin.counter

import android.content.Context
import com.github.denisidoro.hellokotlin.R

class CounterViewModel(context: Context, i: Int) {

    val text = i.toString() + " " + context.getString(R.string.hello)

}
