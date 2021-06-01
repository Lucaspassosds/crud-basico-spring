package com.github.crudbasico.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.crudbasico.models.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {
	
}
