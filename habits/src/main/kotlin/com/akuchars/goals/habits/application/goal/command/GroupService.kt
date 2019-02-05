package com.akuchars.goals.habits.application.goal.command

import com.akuchars.goals.habits.application.common.command.ColorConverter
import com.akuchars.goals.habits.application.goal.query.TemplateQueryService
import com.akuchars.goals.habits.domain.goal.model.Group
import com.akuchars.goals.habits.domain.goal.repository.GroupRepository
import com.akuchars.goals.habits.kernel.saveWithValidate
import com.akuchars.goals.habits.rest.dto.goal.GroupRestDto
import com.akuchars.goals.habits.rest.dto.goal.ListOfGroupRestDto
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.data.repository.findByIdOrNull
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
    fun save(groupRestDto: GroupRestDto) {
        val color = colorConverter.revert(groupRestDto.color)
        val goalsInGroup = templateQueryService.findAllByGroupId(groupRestDto.id).toSet()
        repository.saveWithValidate(
                groupRestDto,
                { Group(groupRestDto.name, color, goalsInGroup) },
                { true }
        )
    }

    @Transactional
    fun getAllGroups(): ListOfGroupRestDto {
        val listOfGroup = repository.findAll().sortedBy { it.name }
        return listOfGroup.mapNotNull { groupConverter.convert(it) }.let(::ListOfGroupRestDto)
    }

    @Transactional
    fun getGroupById(id: Long): Option<GroupRestDto> {
        return repository.findByIdOrNull(id)
                ?.let(groupConverter::convert)
                .option()
    }
}