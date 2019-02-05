package com.akuchars.goals.habits.application.habit.command

import com.akuchars.goals.habits.application.common.command.ColorConverter
import com.akuchars.goals.habits.application.habit.query.HabitTemplateQueryService
import com.akuchars.goals.habits.domain.habit.model.HabitGroup
import com.akuchars.goals.habits.domain.habit.repository.HabitGroupRepository
import com.akuchars.goals.habits.rest.dto.goal.HabitGroupRestDto
import com.akuchars.goals.habits.rest.dto.goal.ListOfHabitGroupRestDto
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GroupService(
        private val repository: HabitGroupRepository,
        private val colorConverter: ColorConverter,
        private val templateQueryService: HabitTemplateQueryService,
        private val groupConverter: HabitGroupConverter
) {

    fun save(groupRestDto: HabitGroupRestDto) {
        val color = colorConverter.revert(groupRestDto.color)
        val goalsInGroup = templateQueryService.findAllByGroupId(groupRestDto.id).toSet()
        repository.save(HabitGroup(groupRestDto.name, color, goalsInGroup))
    }

    fun getAllGroups(): ListOfHabitGroupRestDto {
        val listOfGroup = repository.findAll().sortedBy { it.name }
        return listOfGroup.mapNotNull { groupConverter.convert(it) }.let(::ListOfHabitGroupRestDto)
    }

    @Transactional
    fun getGroupById(id: Long): Option<HabitGroupRestDto> {
        return repository.findByIdOrNull(id)
                ?.let(groupConverter::convert)
                .option()
    }
}