package com.akuchars.goals.habits.infrastructure.goal

import com.akuchars.goals.habits.application.goal.command.GroupConverter
import com.akuchars.goals.habits.application.goal.query.GroupQueryService
import com.akuchars.goals.habits.domain.goal.repository.GroupRepository
import com.akuchars.goals.habits.kernel.orNull
import com.akuchars.goals.habits.rest.dto.goal.GroupRestDto
import org.springframework.stereotype.Component

@Component
class GroupQueryServiceImpl(
        val repository: GroupRepository,
        val converter: GroupConverter
) : GroupQueryService {

    override fun findAll(): List<GroupRestDto> {
        return repository.findAll().mapNotNull(converter::convert)
    }

    override fun findById(id: Long): GroupRestDto? {
        return repository.findById(id).map(converter::convert).orNull
    }
}
