package com.akuchars.goals.habits.infrastructure.goal

import com.akuchars.goals.habits.application.common.command.ColorConverter
import com.akuchars.goals.habits.application.goal.command.TemplateConverter
import com.akuchars.goals.habits.domain.goal.model.Template
import com.akuchars.goals.habits.rest.dto.goal.GoalTemplateRestDto
import org.springframework.stereotype.Component

@Component
class TemplateConverterImpl (val colorConverter: ColorConverter): TemplateConverter {

    override fun convert(goalTemplate: Template): GoalTemplateRestDto {
        return GoalTemplateRestDto(
                goalTemplate.id!!,
                goalTemplate.name,
                goalTemplate.schedule,
                goalTemplate.group.id!!,
                colorConverter.convert(goalTemplate.group.color)!!
        )
    }
}