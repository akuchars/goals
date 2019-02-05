package com.akuchars.goals.habits.domain.habit.repository

import com.akuchars.goals.habits.domain.habit.model.HabitTemplate
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository

interface HabitTemplateRepository : CrudRepository<HabitTemplate, Long>, QuerydslPredicateExecutor<HabitTemplate>