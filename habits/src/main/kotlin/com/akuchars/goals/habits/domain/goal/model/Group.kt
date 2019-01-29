package com.akuchars.goals.habits.domain.goal.model

import com.akuchars.goals.core.domain.AbstractJpaEntity
import com.akuchars.goals.habits.domain.common.model.Color
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.OneToMany

@Entity
class Group(
        val name: String,
        @Enumerated(EnumType.STRING)
        val color: Color,
        @OneToMany(mappedBy = D_GROUP, cascade = [CascadeType.ALL], orphanRemoval = true)
        val goals: Set<Template>

) : AbstractJpaEntity() {
    companion object {
        const val D_GROUP = "group"
    }
}

