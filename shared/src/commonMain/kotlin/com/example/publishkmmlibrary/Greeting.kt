package com.example.publishkmmlibrary

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun sayHello() = "Hello from KMM Library"

}