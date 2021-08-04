package com.github.dudgns0507.kref.pref

import android.content.SharedPreferences
import com.github.dudgns0507.kref.KrefManager
import com.github.dudgns0507.kref.pref.base.Preference
import kotlin.reflect.KProperty

open class FloatPref(default: Float = 0f, name: String = "") : Preference<Float>(default, name) {
    override val prefs: SharedPreferences = KrefManager.instance.prefs

    override fun getValue(thisRef: Any?, property: KProperty<*>): Float {
        return getPreference(when {
            name.isBlank() -> "${property.name}_Kref"
            else -> name
        }, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) {
        setPreference(when {
            name.isBlank() -> "${property.name}_Kref"
            else -> name
        }, value)
    }
}