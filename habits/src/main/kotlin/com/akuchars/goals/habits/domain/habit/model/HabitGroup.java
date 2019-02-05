package com.akuchars.goals.habits.domain.habit.model;

import static com.akuchars.goals.habits.domain.habit.model.GoalObject.DB_SCHEMA_NAME;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jetbrains.annotations.NotNull;

import com.akuchars.goals.core.domain.AbstractJpaEntity;
import com.akuchars.goals.habits.domain.common.model.Color;

import kotlin.jvm.internal.Intrinsics;

@Entity
@SuppressWarnings("NullabilityAnnotations")
@Table(schema = DB_SCHEMA_NAME, name = "goals_group")
public class HabitGroup extends AbstractJpaEntity {
	@NotNull private static final String D_GROUP = "group";

	private String name;

	@Enumerated(EnumType.STRING)
	private Color color;

	@OneToMany(
		mappedBy = D_GROUP,
		cascade = {CascadeType.ALL},
		orphanRemoval = true
	)
	private Set<HabitTemplate> goals;


	public HabitGroup(@NotNull String name, @NotNull Color color, @NotNull Set<HabitTemplate> goals) {
		Intrinsics.checkParameterIsNotNull(name, "name");
		Intrinsics.checkParameterIsNotNull(color, "color");
		Intrinsics.checkParameterIsNotNull(goals, "goals");
		this.name = name;
		this.color = color;
		this.goals = goals;
	}

	public HabitGroup() {
	}

	@NotNull
	public String getName() {
		return this.name;
	}

	@NotNull
	public Color getColor() {
		return this.color;
	}

	@NotNull
	public Set<HabitTemplate> getGoals() {
		return this.goals;
	}

}
