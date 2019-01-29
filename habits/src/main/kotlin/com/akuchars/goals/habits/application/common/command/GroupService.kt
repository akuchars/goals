package com.akuchars.goals.habits.application.common.command

import com.akuchars.goals.habits.application.goal.query.TemplateQueryService
import com.akuchars.goals.habits.domain.goal.model.Group
import com.akuchars.goals.habits.domain.goal.model.QGroup
import com.akuchars.goals.habits.domain.goal.model.QTemplate
import com.akuchars.goals.habits.domain.goal.repository.GroupRepository
import com.akuchars.goals.habits.domain.goal.repository.TemplateRepository
import com.akuchars.goals.habits.kernel.saveWithWalidate
import com.akuchars.goals.habits.rest.dto.goal.GroupRestDto
import io.vavr.control.Either
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GroupService(
        val repository: GroupRepository,
        val colorConverter: ColorConverter,
        val templateQueryService: TemplateQueryService
) {

    private val template: QTemplate = QTemplate.template
    private val group: QGroup = QGroup.group

    @Transactional
    fun save(groupRestDto: GroupRestDto): Either<Throwable, Group> {
        val color = colorConverter.revert(groupRestDto.color)
        val goalsInGroup = templateQueryService.findAllByGroupId(groupRestDto.id).toSet()
        return repository.saveWithWalidate(
                groupRestDto,
                { Group(groupRestDto.name, color, goalsInGroup) },
                { true }
        )
    }
}