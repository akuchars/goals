package com.akuchars.goals.habits.domain.goal.repository

import com.akuchars.goals.habits.domain.goal.model.Group
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.data.repository.CrudRepository

interface GroupRepository : CrudRepository<Group, Long>, QuerydslPredicateExecutor<Group>