package com.github.dudgns0507.sample

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        KrefManager.init(this)
    }
}