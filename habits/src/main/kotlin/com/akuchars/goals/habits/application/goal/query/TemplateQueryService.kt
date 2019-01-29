package com.akuchars.goals.habits.application.goal.query

import com.akuchars.goals.habits.domain.goal.model.Template

interface TemplateQueryService {
    fun findAllByGroupId(groupId: Long): Iterable<Template>
}