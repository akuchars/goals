package com.akuchars.goals.habits.application.habit.query

import com.akuchars.goals.habits.domain.habit.model.HabitTemplate

interface HabitTemplateQueryService {
    fun findAllByGroupId(groupId: Long): Iterable<HabitTemplate>
}