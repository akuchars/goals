package com.akuchars.goals.habits.companion

import com.akuchars.goals.habits.kernel.fromJson
import org.springframework.test.web.servlet.ResultActions
import kotlin.reflect.KClass

fun <T> ResultActions.andGet(classOf: Class<T>): T = this.andReturn().response.contentAsString.fromJson(classOf)
fun <T : Any> ResultActions.andGet(classOf: KClass<T>): T = this.andGet(classOf.java)
