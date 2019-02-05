package com.akuchars.goals.habits.domain.habit.repository

import com.akuchars.goals.habits.domain.habit.model.HabitActual
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository


interface HabitActualRepository : CrudRepository<HabitActual, Long>, QuerydslPredicateExecutor<HabitActual>