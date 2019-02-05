package com.akuchars.goals.habits.infrastructure.goal;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import com.akuchars.goals.habits.application.habit.query.HabitTemplateQueryService;
import com.akuchars.goals.habits.domain.habit.model.HabitTemplate;
import com.akuchars.goals.habits.domain.habit.model.QHabitTemplate;
import com.akuchars.goals.habits.domain.habit.repository.HabitTemplateRepository;

@Service
public class HabitTemplateQueryServiceImpl implements HabitTemplateQueryService {

	@NotNull private final HabitTemplateRepository habitTemplateRepository;

	@NotNull private static final QHabitTemplate template = QHabitTemplate.habitTemplate;


	public HabitTemplateQueryServiceImpl(@NotNull HabitTemplateRepository habitTemplateRepository) {
		this.habitTemplateRepository = habitTemplateRepository;
	}

	@NotNull
	@Override
	public Iterable<HabitTemplate> findAllByGroupId(long groupId) {
		return habitTemplateRepository.findAll(template.group.id.eq(groupId));
	}
}
