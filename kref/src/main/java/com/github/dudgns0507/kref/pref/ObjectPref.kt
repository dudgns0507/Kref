package com.github.dudgns0507.kref.pref

import android.content.SharedPreferences
import com.github.dudgns0507.kref.KrefManager
import com.github.dudgns0507.kref.error.KrefException
import com.github.dudgns0507.kref.ext.fromGson
import com.github.dudgns0507.kref.ext.toJson
import com.github.dudgns0507.kref.pref.base.Preference
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

open class ObjectPref<T : Any>(val type: KClass<T>, default: T, name: String = "") :
    Preference<T>(default, name) {
    override val prefs: SharedPreferences = KrefManager.instance.prefs

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getPreference(
            when {
                name.isBlank() -> "${property.name}_Kref"
                else -> name
            }, default
        )
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        setPreference(
            when {
                name.isBlank() -> "${property.name}_Kref"
                else -> name
            }, value
        )
    }

    override fun getPreference(name: String, default: T): T = with(prefs) {
        try {
            return getString(name, "")?.fromGson(type.java) ?: kotlin.run {
                default.toJson().fromGson(type.java)
            }
        } catch (e: Exception) {
            throw KrefException("This type is not supported in Kref (Gson Exception)")
        }
    }

    override fun setPreference(name: String, value: T) = with(prefs.edit()) {
        try {
            putString(name, value.toJson()).apply()
        } catch (e: Exception) {
            throw KrefException("This type is not supported in Kref (Gson Exception)")
        }
    }
}