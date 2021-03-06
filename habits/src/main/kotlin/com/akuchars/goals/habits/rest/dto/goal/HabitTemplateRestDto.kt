package com.akuchars.goals.habits.rest.dto.goal

class HabitTemplateRestDto (
        val id: Long,
        val name: String,
        val description: String,
        val schedule: ScheduleTypeRestDto,
        val groupId: Long,
        val color: ColorRestDto
)