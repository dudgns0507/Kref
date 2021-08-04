package com.github.dudgns0507.kref.pref

import android.content.SharedPreferences
import com.github.dudgns0507.kref.KrefManager
import com.github.dudgns0507.kref.pref.base.Preference
import kotlin.reflect.KProperty

open class LongPref(default: Long = 0L, name: String = "") : Preference<Long>(default, name) {
    override val prefs: SharedPreferences = KrefManager.instance.prefs

    override fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return getPreference(when {
            name.isBlank() -> "${property.name}_Kref"
            else -> name
        }, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        setPreference(when {
            name.isBlank() -> "${property.name}_Kref"
            else -> name
        }, value)
    }

    override fun getPreference(name: String, default: Long): Long = with(prefs) {
        return getLong(name, default)
    }

    override fun setPreference(name: String, value: Long) = with(prefs.edit()) {
        putLong(name, value).apply()
    }
}