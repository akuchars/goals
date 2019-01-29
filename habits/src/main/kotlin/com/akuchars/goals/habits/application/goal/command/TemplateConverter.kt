package com.akuchars.goals.habits.application.goal.command

import com.akuchars.goals.habits.domain.goal.model.Template
import com.akuchars.goals.habits.rest.dto.goal.GoalTemplateRestDto
import org.springframework.core.convert.converter.Converter


interface TemplateConverter : Converter<Template, GoalTemplateRestDto>