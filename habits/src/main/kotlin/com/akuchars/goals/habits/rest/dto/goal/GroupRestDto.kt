package com.akuchars.goals.habits.rest.dto.goal

class GroupRestDto (
        val id: Long,
        val name: String,
        val color: ColorRestDto,
        val goals: Set<GoalTemplateRestDto>
)