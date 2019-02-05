package com.akuchars.goals.habits.domain.habit.repository

import com.akuchars.goals.habits.domain.habit.model.HabitGroup
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository

interface HabitGroupRepository : CrudRepository<HabitGroup, Long>, QuerydslPredicateExecutor<HabitGroup>