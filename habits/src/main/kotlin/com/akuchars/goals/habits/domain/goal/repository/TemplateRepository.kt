package com.akuchars.goals.habits.domain.goal.repository

import com.akuchars.goals.habits.domain.goal.model.Template
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository

interface TemplateRepository : CrudRepository<Template, Long>, QuerydslPredicateExecutor<Template>