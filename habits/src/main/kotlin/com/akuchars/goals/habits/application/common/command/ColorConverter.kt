package com.akuchars.goals.habits.application.common.command

import com.akuchars.goals.habits.domain.common.model.Color
import com.akuchars.goals.habits.rest.dto.goal.ColorRestDto
import org.springframework.core.convert.converter.Converter

interface ColorConverter: Converter<Color, ColorRestDto>