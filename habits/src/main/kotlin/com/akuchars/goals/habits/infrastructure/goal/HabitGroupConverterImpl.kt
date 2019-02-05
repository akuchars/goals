package com.akuchars.goals.habits.infrastructure.goal

import com.akuchars.goals.habits.application.common.command.ColorConverter
import com.akuchars.goals.habits.application.habit.command.HabitTemplateConverter
import com.akuchars.goals.habits.application.habit.command.HabitGroupConverter
import com.akuchars.goals.habits.domain.habit.model.HabitGroup
import com.akuchars.goals.habits.rest.dto.goal.HabitGroupRestDto
import org.springframework.stereotype.Component

@Component
class HabitGroupConverterImpl(
        val colorConverter: ColorConverter,
        val goalsConverter: HabitTemplateConverter
) : HabitGroupConverter {

    override fun convert(goals: HabitGroup): HabitGroupRestDto {
        return HabitGroupRestDto(
                goals.id!!,
                goals.name,
                colorConverter.convert(goals.color)!!,
                goals.goals.mapNotNull(goalsConverter::convert).toSet()
        )
    }
}
