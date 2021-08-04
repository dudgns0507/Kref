package com.github.dudgns0507.kref.ext

import com.google.gson.Gson

fun Any?.toJson(): String {
    this?.let {
        return Gson().toJson(it)
    } ?: kotlin.run {
        return ""
    }
}

fun <T> String.fromGson(c: Class<T>): T {
    return Gson().fromJson(this, c)
}