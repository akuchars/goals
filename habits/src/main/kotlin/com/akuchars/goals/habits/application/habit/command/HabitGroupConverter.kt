package com.akuchars.goals.habits.application.habit.command

import com.akuchars.goals.habits.domain.habit.model.HabitGroup
import com.akuchars.goals.habits.rest.dto.goal.HabitGroupRestDto
import org.springframework.core.convert.converter.Converter

interface HabitGroupConverter : Converter<HabitGroup, HabitGroupRestDto>