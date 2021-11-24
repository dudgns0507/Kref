package com.github.dudgns0507.kref.ext

import com.google.gson.Gson
import kotlin.reflect.KProperty

fun Any?.toJson(): String {
    this?.let {
        return Gson().toJson(it)
    } ?: kotlin.run {
        return ""
    }
}

fun String.key(): String {
    return "${this}_Kref"
}

fun KProperty<*>.key(key: String): String {
    return when {
        key.isBlank() -> name.key()
        else -> key
    }
}