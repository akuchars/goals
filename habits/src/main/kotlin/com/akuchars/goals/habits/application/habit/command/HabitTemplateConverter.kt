package com.akuchars.goals.habits.application.habit.command

import com.akuchars.goals.habits.domain.habit.model.HabitTemplate
import com.akuchars.goals.habits.rest.dto.goal.HabitTemplateRestDto
import org.springframework.core.convert.converter.Converter

interface HabitTemplateConverter : Converter<HabitTemplate, HabitTemplateRestDto>