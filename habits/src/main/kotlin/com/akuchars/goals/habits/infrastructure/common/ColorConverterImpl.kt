package com.akuchars.goals.habits.infrastructure.common

import com.akuchars.goals.habits.application.common.command.ColorConverter
import com.akuchars.goals.habits.domain.common.model.Color
import com.akuchars.goals.habits.rest.dto.goal.ColorRestDto
import org.springframework.stereotype.Component

@Component
class ColorConverterImpl: ColorConverter {
    override fun revert(colorRestDto: ColorRestDto): Color {
        return Color.valueOf(colorRestDto.name)
    }

    override fun convert(color: Color): ColorRestDto? {
        return ColorRestDto.valueOf(color.name)
    }
}