package com.akuchars.goals.habits.domain.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.jetbrains.annotations.NotNull;


//https://www.logicbig.com/tutorials/spring-framework/spring-data/query-dsl-basic.html
//https://stackoverflow.com/questions/48557630/how-to-user-querydsl-and-generate-file-in-kotlin
@Entity
public class ExampleJavaEntity {

	@NotNull
	@Column
	private Long id;

	public ExampleJavaEntity(@NotNull Long id) {
		this.id = id;
	}
}
