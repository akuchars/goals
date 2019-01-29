package com.akuchars.goals.habits.domain.goal.model

import com.akuchars.goals.core.domain.AbstractJpaEntity
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Template(
        val name: String,
        val description: String,
        val schedule: String,
        @ManyToOne
        @JoinColumn(name = "group_id")
        val group: Group
) : AbstractJpaEntity()