package com.akuchars.goals.habits.application.goal.query

import com.akuchars.goals.habits.domain.goal.model.Template
import org.springframework.data.querydsl.QuerydslPredicateExecutor

interface TemplateQueryService : QuerydslPredicateExecutor<Template> {
    fun findAllByGroupId(groupId: Long): Iterable<Template>
}