package com.akuchars.goals.habits.infrastructure.goal

import com.akuchars.goals.habits.application.habit.command.HabitGroupConverter
import com.akuchars.goals.habits.application.habit.query.HabitGroupQueryService
import com.akuchars.goals.habits.domain.habit.repository.HabitGroupRepository
import com.akuchars.goals.habits.kernel.orNull
import com.akuchars.goals.habits.rest.dto.goal.HabitGroupRestDto
import org.springframework.stereotype.Component

@Component
class HabitGroupQueryServiceImpl(
        val repository: HabitGroupRepository,
        val converter: HabitGroupConverter
) : HabitGroupQueryService {

    override fun findAll(): List<HabitGroupRestDto> {
        return repository.findAll().mapNotNull(converter::convert)
    }

    override fun findById(id: Long): HabitGroupRestDto? {
        return repository.findById(id).map(converter::convert).orNull
    }
}
