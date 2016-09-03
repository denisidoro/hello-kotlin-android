package com.github.denisidoro.hellokotlin.model

import com.google.gson.annotations.SerializedName

data class Joke(@SerializedName("value")
                val value: Value)

data class Value(@SerializedName("id")
                 val id: Int,
                 @SerializedName("joke")
                 val joke: String)
