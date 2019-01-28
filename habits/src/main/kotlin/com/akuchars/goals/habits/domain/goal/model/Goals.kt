package com.akuchars.goals.habits.domain.goal.model

import com.akuchars.goals.core.domain.AbstractJpaEntity
import com.akuchars.goals.habits.domain.common.model.Color
import com.akuchars.goals.habits.domain.goal.model.Groups.D_GROUP
import java.time.LocalDate
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class GoalsGroup(
        val name: String,
        @Enumerated(EnumType.STRING)
        val color: Color,
        @OneToMany(mappedBy = D_GROUP, cascade = [CascadeType.ALL], orphanRemoval = true)
        val gaols: Set<GoalTemplate>

) : AbstractJpaEntity()

@Entity
class GoalTemplate(
        val name: String,
        val description: String,
        val schedule: String,
        @ManyToOne
        @JoinColumn(name = "group_id")
        val group: GoalsGroup
) : AbstractJpaEntity()

@Entity
class GoalActual(
        val date: LocalDate,
        val done: Boolean,
        @OneToOne
        @JoinColumn(name = "goal_id")
        val goal: GoalTemplate
) : AbstractJpaEntity()

object Groups {
    const val D_GROUP = "group"
}
