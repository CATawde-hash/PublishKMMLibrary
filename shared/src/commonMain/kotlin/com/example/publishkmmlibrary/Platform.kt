package com.example.publishkmmlibrary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform