package com.akuchars.goals.habits.application.goal.query

import com.akuchars.goals.habits.rest.dto.goal.GroupRestDto

interface GroupQueryService {

    fun findAll(): Iterable<GroupRestDto>
    fun findById(id: Long): GroupRestDto?
}