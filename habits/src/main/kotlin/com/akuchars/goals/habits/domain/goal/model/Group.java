package com.akuchars.goals.habits.domain.goal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import org.jetbrains.annotations.NotNull;

import com.akuchars.goals.core.domain.AbstractJpaEntity;
import com.akuchars.goals.habits.domain.common.model.Color;

import kotlin.jvm.internal.Intrinsics;

@Entity
@SuppressWarnings("NullabilityAnnotations")
public class Group extends AbstractJpaEntity {
	@NotNull private static final String D_GROUP = "group";

	private String name;

	@Enumerated(EnumType.STRING)
	private Color color;

	@OneToMany(
		mappedBy = D_GROUP,
		cascade = {CascadeType.ALL},
		orphanRemoval = true
	)
	private Set<Template> goals;


	public Group(@NotNull String name, @NotNull Color color, @NotNull Set<Template> goals) {
		Intrinsics.checkParameterIsNotNull(name, "name");
		Intrinsics.checkParameterIsNotNull(color, "color");
		Intrinsics.checkParameterIsNotNull(goals, "goals");
		this.name = name;
		this.color = color;
		this.goals = goals;
	}

	public Group() {
	}

	@NotNull
	public final String getName() {
		return this.name;
	}

	@NotNull
	public final Color getColor() {
		return this.color;
	}

	@NotNull
	public final Set<Template> getGoals() {
		return this.goals;
	}

}
