package com.akuchars.goals.habits.domain.goal.model;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.jetbrains.annotations.NotNull;

import com.akuchars.goals.core.domain.AbstractJpaEntity;

import kotlin.jvm.internal.Intrinsics;

@Entity
@Access(AccessType.FIELD)
@SuppressWarnings("NullabilityAnnotations")
public class Actual extends AbstractJpaEntity {
	private final LocalDate date;
	private final boolean done;
	@OneToOne
	@JoinColumn(
		name = "goal_id"
	)
	private final Template goal;

	@NotNull
	public final LocalDate getDate() {
		return this.date;
	}

	public final boolean getDone() {
		return this.done;
	}

	@NotNull
	public final Template getGoal() {
		return this.goal;
	}

	public Actual(@NotNull LocalDate date, boolean done, @NotNull Template goal) {
		Intrinsics.checkParameterIsNotNull(date, "date");
		Intrinsics.checkParameterIsNotNull(goal, "goal");
		this.date = date;
		this.done = done;
		this.goal = goal;
	}
}