package com.akuchars.goals.habits.infrastructure.goal;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import com.akuchars.goals.habits.application.goal.query.TemplateQueryService;
import com.akuchars.goals.habits.domain.goal.model.QTemplate;
import com.akuchars.goals.habits.domain.goal.model.Template;
import com.akuchars.goals.habits.domain.goal.repository.TemplateRepository;

@Service
public class TemplateQueryServiceImpl implements TemplateQueryService {

	@NotNull private final TemplateRepository templateRepository;

	@NotNull private static final QTemplate template = QTemplate.template;


	public TemplateQueryServiceImpl(@NotNull TemplateRepository templateRepository) {
		this.templateRepository = templateRepository;
	}

	@NotNull
	@Override
	public Iterable<Template> findAllByGroupId(long groupId) {
		return templateRepository.findAll(template.group.id.eq(groupId));
	}
}
