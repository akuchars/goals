package com.akuchars.goals.habits.infrastructure.goal

import com.akuchars.goals.habits.application.goal.query.TemplateQueryService
import com.akuchars.goals.habits.domain.goal.model.QTemplate
import com.akuchars.goals.habits.domain.goal.model.Template
import com.akuchars.goals.habits.domain.goal.repository.TemplateRepository
import org.springframework.stereotype.Service

@Service
class TemplateQueryServiceImpl (val repository: TemplateRepository): TemplateQueryService {

    private var template: QTemplate = QTemplate.template

    override fun findAllByGroupId(groupId: Long): Iterable<Template> {
        return repository.findAll(template.group.id.eq(groupId))
    }
}