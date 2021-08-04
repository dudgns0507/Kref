package com.github.dudgns0507.sample

import android.app.Application
import com.github.dudgns0507.kref.KrefManager

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        KrefManager.init(this)
    }
}