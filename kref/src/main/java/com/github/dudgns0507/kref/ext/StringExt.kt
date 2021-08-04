package com.github.dudgns0507.kref.ext

import com.google.gson.Gson

fun Any.toJson(): String {
    return Gson().toJson(this)
}