package com.akuchars.goals.habits.application.goal.command

import com.akuchars.goals.habits.domain.goal.model.Group
import com.akuchars.goals.habits.rest.dto.goal.GroupRestDto
import org.springframework.core.convert.converter.Converter

interface GroupConverter : Converter<Group, GroupRestDto>