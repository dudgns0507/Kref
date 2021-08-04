package com.github.dudgns0507.kref.pref

import android.content.SharedPreferences
import com.github.dudgns0507.kref.KrefManager
import com.github.dudgns0507.kref.pref.base.Preference
import kotlin.reflect.KProperty

open class IntPref(default: Int = 0, name: String = "") : Preference<Int>(default, name) {
    override val prefs: SharedPreferences = KrefManager.instance.prefs

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return getPreference(when {
            name.isBlank() -> "${property.name}_Kref"
            else -> name
        }, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        setPreference(when {
            name.isBlank() -> "${property.name}_Kref"
            else -> name
        }, value)
    }
}