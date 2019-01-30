package com.akuchars.goals.habits.domain.goal.model;

import static com.akuchars.goals.habits.domain.goal.model.GoalObject.DB_SCHEMA_NAME;

import java.time.LocalDate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;

import com.akuchars.goals.core.domain.AbstractJpaEntity;

import kotlin.jvm.internal.Intrinsics;

@Entity
@Access(AccessType.FIELD)
@Table(schema = DB_SCHEMA_NAME, name = "goal_actual")
@SuppressWarnings("NullabilityAnnotations")
public class Actual extends AbstractJpaEntity {
	private LocalDate date;
	private boolean done;
	@OneToOne
	@JoinColumn(
		name = "goal_id"
	)
	private final Template goal;

	@NotNull
	public LocalDate getDate() {
		return this.date;
	}

	public boolean getDone() {
		return this.done;
	}

	@NotNull
	public Template getGoal() {
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