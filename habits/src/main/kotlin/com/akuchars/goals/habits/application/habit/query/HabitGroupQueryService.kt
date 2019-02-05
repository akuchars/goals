package com.akuchars.goals.habits.application.habit.query

import com.akuchars.goals.habits.rest.dto.goal.HabitGroupRestDto

interface HabitGroupQueryService {

    fun findAll(): Iterable<HabitGroupRestDto>
    fun findById(id: Long): HabitGroupRestDto?
}