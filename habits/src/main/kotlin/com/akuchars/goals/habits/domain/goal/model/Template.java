package com.akuchars.goals.habits.domain.goal.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.jetbrains.annotations.NotNull;

import com.akuchars.goals.core.domain.AbstractJpaEntity;

import kotlin.jvm.internal.Intrinsics;

@Entity
@Access(AccessType.FIELD)
@SuppressWarnings("NullabilityAnnotations")
public final class Template extends AbstractJpaEntity {
	private String name;
	private String description;
	private String schedule;
	@ManyToOne
	@JoinColumn(
		name = "group_id"
	)
	private Group group;

	public Template(@NotNull String name, @NotNull String description, @NotNull String schedule, @NotNull Group group) {
		Intrinsics.checkParameterIsNotNull(name, "name");
		Intrinsics.checkParameterIsNotNull(description, "description");
		Intrinsics.checkParameterIsNotNull(schedule, "schedule");
		Intrinsics.checkParameterIsNotNull(group, "group");
		this.name = name;
		this.description = description;
		this.schedule = schedule;
		this.group = group;
	}

	public Template() {
	}

	@NotNull
	public final String getName() {
		return this.name;
	}

	@NotNull
	public final String getDescription() {
		return this.description;
	}

	@NotNull
	public final String getSchedule() {
		return this.schedule;
	}

	@NotNull
	public final Group getGroup() {
		return this.group;
	}
}
