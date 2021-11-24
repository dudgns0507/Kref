package com.github.dudgns0507.sample

import com.github.dudgns0507.kref.pref.Kref

class PrefManager {
    companion object {
        val instance = PrefManager()
    }

    var kString: String? by Kref(default = null)
}