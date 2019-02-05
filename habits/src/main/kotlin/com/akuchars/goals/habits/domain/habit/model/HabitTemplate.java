package com.akuchars.goals.habits.domain.habit.model;

import static com.akuchars.goals.habits.domain.habit.model.GoalObject.DB_SCHEMA_NAME;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;

import com.akuchars.goals.core.domain.AbstractJpaEntity;

import kotlin.jvm.internal.Intrinsics;

@Entity
@Access(AccessType.FIELD)
@Table(schema = DB_SCHEMA_NAME, name = "goal_template")
@SuppressWarnings("NullabilityAnnotations")
public final class HabitTemplate extends AbstractJpaEntity {
	private String name;
	private String description;
	private String schedule;
	@ManyToOne
	@JoinColumn(
		name = "group_id"
	)
	private HabitGroup group;

	public HabitTemplate(@NotNull String name, @NotNull String description, @NotNull String schedule, @NotNull HabitGroup group) {
		Intrinsics.checkParameterIsNotNull(name, "name");
		Intrinsics.checkParameterIsNotNull(description, "description");
		Intrinsics.checkParameterIsNotNull(schedule, "schedule");
		Intrinsics.checkParameterIsNotNull(group, "group");
		this.name = name;
		this.description = description;
		this.schedule = schedule;
		this.group = group;
	}

	public HabitTemplate() {
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
	public final HabitGroup getGroup() {
		return this.group;
	}
}
