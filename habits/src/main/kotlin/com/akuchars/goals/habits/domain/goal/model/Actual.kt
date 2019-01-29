package com.akuchars.goals.habits.domain.goal.model

import com.akuchars.goals.core.domain.AbstractJpaEntity
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
class Actual(
        val date: LocalDate,
        val done: Boolean,
        @OneToOne
        @JoinColumn(name = "goal_id")
        val goal: Template
) : AbstractJpaEntity()