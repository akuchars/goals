package com.akuchars.goals.habits

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.util.Arrays

@SpringBootApplication
@EnableWebMvc
class HabitsApplication

fun main(args: Array<String>) {
    runApplication<HabitsApplication>(*args)
}