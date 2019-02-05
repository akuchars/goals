package com.akuchars.goals.habits.infrastructure.goal

import com.akuchars.goals.habits.application.common.command.ColorConverter
import com.akuchars.goals.habits.application.habit.command.HabitTemplateConverter
import com.akuchars.goals.habits.domain.habit.model.HabitTemplate
import com.akuchars.goals.habits.rest.dto.goal.HabitTemplateRestDto
import org.springframework.stereotype.Component

@Component
class HabitTemplateConverterImpl (val colorConverter: ColorConverter): HabitTemplateConverter {

    override fun convert(goalTemplate: HabitTemplate): HabitTemplateRestDto {
        return HabitTemplateRestDto(
                goalTemplate.id!!,
                goalTemplate.name,
                goalTemplate.description,
                goalTemplate.schedule,
                goalTemplate.group.id!!,
                colorConverter.convert(goalTemplate.group.color)!!
        )
    }
}