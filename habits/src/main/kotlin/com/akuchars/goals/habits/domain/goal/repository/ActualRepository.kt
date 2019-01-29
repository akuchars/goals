package com.akuchars.goals.habits.domain.goal.repository

import com.akuchars.goals.habits.domain.goal.model.Actual
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository


interface ActualRepository : CrudRepository<Actual, Long>, QuerydslPredicateExecutor<Actual>