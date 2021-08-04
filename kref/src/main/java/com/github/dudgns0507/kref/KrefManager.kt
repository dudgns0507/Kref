package com.github.dudgns0507.kref

import android.content.Context
import android.content.SharedPreferences

class KrefManager {
    companion object {
        private lateinit var context: Context
        var name: String = "Kref"
        var mode: Int = Context.MODE_PRIVATE

        fun init(
            context: Context,
            name: String = context.packageName,
            mode: Int = Context.MODE_PRIVATE
        ) {
            Companion.context = context
            Companion.name = name
            Companion.mode = mode
        }

        val instance by lazy {
            KrefManager()
        }
    }

    val prefs: SharedPreferences by lazy {
        context.getSharedPreferences("Kref", mode)
    }

    fun clear() = prefs.edit()?.clear()?.apply()
}