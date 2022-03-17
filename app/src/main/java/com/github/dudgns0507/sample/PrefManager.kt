package com.github.dudgns0507.sample

import android.content.Context
import com.github.dudgns0507.kref.pref.Kref

class PrefManager(
    private val context: Context
) {
    private val prefs = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

    var kString: String? by Kref(prefs, default = null)
}