package com.akuchars.goals.habits.application.goal.command

import com.akuchars.goals.habits.application.common.command.ColorConverter
import com.akuchars.goals.habits.application.goal.query.TemplateQueryService
import com.akuchars.goals.habits.domain.goal.model.Group
import com.akuchars.goals.habits.domain.goal.repository.GroupRepository
import com.akuchars.goals.habits.kernel.saveWithValidate
import com.akuchars.goals.habits.rest.dto.goal.GroupRestDto
import com.akuchars.goals.habits.rest.dto.goal.ListOfGroupRestDto
import io.vavr.control.Either
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GroupService(
        private val repository: GroupRepository,
        private val colorConverter: ColorConverter,
        private val templateQueryService: TemplateQueryService,
        private val groupConverter: GroupConverter
) {

    @Transactional
    fun save(groupRestDto: GroupRestDto): Either<Throwable, Group> {
        val color = colorConverter.revert(groupRestDto.color)
        val goalsInGroup = templateQueryService.findAllByGroupId(groupRestDto.id).toSet()
        return repository.saveWithValidate(
                groupRestDto,
                { Group(groupRestDto.name, color, goalsInGroup) },
                { true }
        )
    }

    fun getAllGroups(): ListOfGroupRestDto {
        val listOfGroup = repository.findAll().sortedBy { it.name }
        return listOfGroup.mapNotNull { groupConverter.convert(it) }.let(::ListOfGroupRestDto)
    }
}