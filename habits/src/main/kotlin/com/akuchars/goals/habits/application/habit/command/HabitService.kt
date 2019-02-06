package com.akuchars.goals.habits.application.habit.command

import com.akuchars.goals.habits.application.habit.model.HabitGroupNotFoundException
import com.akuchars.goals.habits.application.habit.query.HabitTemplateQueryService
import com.akuchars.goals.habits.domain.habit.model.HabitActual
import com.akuchars.goals.habits.domain.habit.model.HabitTemplate
import com.akuchars.goals.habits.domain.habit.repository.HabitActualRepository
import com.akuchars.goals.habits.domain.habit.repository.HabitGroupRepository
import com.akuchars.goals.habits.domain.habit.repository.HabitTemplateRepository
import com.akuchars.goals.habits.rest.dto.goal.HabitTemplateRestDto
import com.akuchars.goals.habits.rest.dto.goal.ListOfHabitTemplateRestDto
import io.vavr.control.Option
import io.vavr.kotlin.option
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDate.now

@Service
class HabitService(
        private val groupRepository: HabitGroupRepository,
        private val actualRepository: HabitActualRepository,
        private val repository: HabitTemplateRepository,
        private val converter: HabitTemplateConverter,
        private val queryService: HabitTemplateQueryService
) {

    fun getAllTemplatesBy(groupId: Long?): ListOfHabitTemplateRestDto {
        return when (groupId) {
            null -> getAllTemplate()
            else -> getAllTemplateFromGroup(groupId)
        }
    }

    @Throws(HabitGroupNotFoundException::class)
    fun createTemplate(dto: HabitTemplateRestDto) {
        //todo utworzenie habit actual na podstawie schedula (w kolejce)
        val group = groupRepository.findById(dto.groupId).orElseThrow(::HabitGroupNotFoundException)
        HabitTemplate(dto.name, dto.description, dto.schedule.schedule, group).apply {
            repository.save(this)
            actualRepository.save(HabitActual(now(), false, this))
        }
    }

    internal fun getAllTemplate(): ListOfHabitTemplateRestDto {
        return repository.findAll()
                .mapNotNull(converter::convert)
                .let(::ListOfHabitTemplateRestDto)
    }

    internal fun getAllTemplateFromGroup(groupId: Long): ListOfHabitTemplateRestDto {
        return queryService.findAllByGroupId(groupId)
                .mapNotNull(converter::convert)
                .let(::ListOfHabitTemplateRestDto)
    }

    fun getTemplateById(id: Long): Option<HabitTemplateRestDto> {
        return repository.findByIdOrNull(id)?.let(converter::convert).option()
    }
}