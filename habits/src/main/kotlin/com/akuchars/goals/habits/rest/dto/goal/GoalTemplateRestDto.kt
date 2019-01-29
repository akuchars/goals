package com.akuchars.goals.habits.rest.dto.goal

class GoalTemplateRestDto (
        val id: Long,
        val name: String,
        val schedule: String,
        val groupId: Long,
        val color: ColorRestDto
)