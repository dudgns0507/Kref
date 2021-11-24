package com.github.dudgns0507.kref.pref

import android.content.SharedPreferences
import com.github.dudgns0507.kref.KrefManager
import com.github.dudgns0507.kref.error.KrefException
import com.github.dudgns0507.kref.ext.key
import com.github.dudgns0507.kref.ext.toJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class Kref<T>(
    private val default: T?, var name: String = ""
) : ReadWriteProperty<Any?, T?> {
    private val prefs: SharedPreferences = KrefManager.instance.prefs

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        name = property.key(name)
        return getPreference(name, default)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        name = property.key(name)
        setPreference(name, value)
    }

    @Suppress("UNCHECKED_CAST")
    private fun getPreference(name: String, default: T?): T? = with(prefs) {
        return when (default) {
            is String -> getString(name, default)
            is Long -> getLong(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            is List<*> -> Gson().fromJson(
                getString(name, default.toJson()),
                object : TypeToken<T>() {}.type
            )
            is Map<*, *> -> Gson().fromJson(
                getString(name, default.toJson()),
                object : TypeToken<T>() {}.type
            )
            else -> try {
                Gson().fromJson<T>(
                    getString(name, default.toJson()),
                    object : TypeToken<T>() {}.type
                )
            } catch (e: Exception) {
                throw KrefException("This type is not supported in Kref")
            }
        } as T
    }

    private fun setPreference(name: String, value: T?) = with(prefs.edit()) {
        when (value) {
            is String -> putString(name, value)
            is Long -> putLong(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            is List<*> -> putString(name, value.toJson())
            is Map<*, *> -> putString(name, value.toJson())
            else -> try {
                putString(name, value.toJson())
            } catch (e: Exception) {
                throw KrefException("This type is not supported in Kref")
            }
        }.apply()
    }
}