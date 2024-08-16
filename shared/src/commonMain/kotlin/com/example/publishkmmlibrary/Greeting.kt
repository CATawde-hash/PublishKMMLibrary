package com.example. git remote add origin https://github.com/CATawde-hash/PublishKMMLibrary.git

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }

    fun sayHello() = "Hello from KMM Library"

}