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