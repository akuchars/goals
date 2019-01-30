package com.akuchars.goals.habits.kernel

import com.google.gson.GsonBuilder

fun Any.toJson(): String = GsonBuilder().serializeNulls().create().toJson(this)
fun <T> String.fromJson(classOf: Class<T>): T = GsonBuilder().serializeNulls().create().fromJson(this, classOf)