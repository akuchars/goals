package com.akuchars.goals.core.domain;

import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.jetbrains.annotations.Nullable;

@MappedSuperclass
@Access(AccessType.FIELD)
public abstract class AbstractJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nullable
	protected Long id;

	public AbstractJpaEntity() {
	}

	@Nullable
	public Long getId() {
		return id;
	}

	public void setId(@Nullable Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AbstractJpaEntity that = (AbstractJpaEntity) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
