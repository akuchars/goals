package com.akuchars.goals.habits.infrastructure.goal

import com.akuchars.goals.habits.application.common.command.ColorConverter
import com.akuchars.goals.habits.application.goal.command.TemplateConverter
import com.akuchars.goals.habits.application.goal.command.GroupConverter
import com.akuchars.goals.habits.domain.goal.model.Group
import com.akuchars.goals.habits.rest.dto.goal.GroupRestDto
import org.springframework.stereotype.Component

@Component
class GroupConverterImpl(
        val colorConverter: ColorConverter,
        val goalsConverter: TemplateConverter
) : GroupConverter {

    override fun convert(goals: Group): GroupRestDto {
        return GroupRestDto(
                goals.id!!,
                goals.name,
                colorConverter.convert(goals.color)!!,
                goals.goals.mapNotNull(goalsConverter::convert).toSet()
        )
    }
}
