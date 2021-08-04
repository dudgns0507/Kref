package com.github.dudgns0507.sample

import com.github.dudgns0507.kref.pref.StringPref

class PrefManager {
    companion object {
        val instance = PrefManager()
    }

    var kString: String by StringPref(default = "")
}