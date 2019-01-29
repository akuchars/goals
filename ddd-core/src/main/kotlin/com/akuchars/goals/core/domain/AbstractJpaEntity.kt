package com.akuchars.goals.core.domain

import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractJpaEntity(@Id
                              @GeneratedValue
                              var id: Long? = null) {

    override fun toString() = "Entity of type ${this.javaClass.name} with id: $id"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as AbstractJpaEntity
        if (id != other.id)  return false

        return true
    }

    override fun hashCode(): Int = id?.hashCode() ?: 0

    companion object {
        private val serialVersionUID = -5554308939380869754L
    }

}